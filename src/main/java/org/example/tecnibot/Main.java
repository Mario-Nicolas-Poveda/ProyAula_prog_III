package org.example.tecnibot;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class Main {
    public static void main(String[] args) {
        System.out.println("Prueba de que el programa ejecuta correctamente\n");

        Administrador admin = new Administrador("Admin", "admin@example.com", "adminpass");
        Tecnico tecnico = new Tecnico("Juan Pérez", "juan@example.com", "tpass");

        System.out.println("Opciones administrador:");
        admin.mostrarOpciones();
        System.out.println("\nOpciones técnico:");
        tecnico.mostrarOpciones();

        Cliente cliente = new Cliente("María López", "555-1234", "Calle Falsa 123");
        Dispositivo dispositivo = new Dispositivo("Teléfono", "Samsung", "S21", cliente);

        Componente comp1 = new Componente("Pantalla", "Pantalla AMOLED", 120.0);
        Componente comp2 = new Componente("Batería", "Batería 4000mAh", 40.0);

        Servicio servicio = new Servicio(dispositivo, tecnico, 30.0);

        // Inicializar la lista privada componentesUtilizados con reflection para evitar NPE
        try {
            Field f = Servicio.class.getDeclaredField("componentesUtilizados");
            f.setAccessible(true);
            f.set(servicio, new ArrayList<Componente>());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
            return;
        }

        servicio.agregarComponente(comp1);
        servicio.agregarComponente(comp2);
        servicio.setCompletado(true);

        System.out.println("\nServicio:");
        System.out.println("Cliente: " + servicio.getDispositivo().getCliente().getNombre());
        System.out.println("Dispositivo: " + servicio.getDispositivo().getMarca() + " " + servicio.getDispositivo().getModelo());
        System.out.println("Costo mano de obra: $" + servicio.getCostoManoObra());
        System.out.println("Componentes utilizados:");
        List<Componente> usados = servicio.getComponentesUtilizados();
        double sumaComponentes = 0.0;
        for (Componente c : usados) {
            System.out.println("- " + c.getNombre() + " (" + c.getDescripcion() + "): $" + c.getPrecio());
            sumaComponentes += c.getPrecio();
        }

        double total = sumaComponentes + servicio.getCostoManoObra();
        Factura factura = new Factura(cliente, servicio, LocalDate.now(), total);

        System.out.println("\nFactura:");
        System.out.println("Fecha: " + factura.getFecha());
        System.out.println("Cliente: " + factura.getCliente().getNombre());
        System.out.println("Total: $" + factura.getTotal());

        // Probar algunos setters
        cliente.setTelefono("999-9999");
        comp1.setPrecio(110.0);
        // recalcular total tras cambio de precio
        double nuevoSuma = 0.0;
        for (Componente c : usados) nuevoSuma += c.getPrecio();
        factura.setTotal(nuevoSuma + servicio.getCostoManoObra());

        System.out.println("\nDespués de cambios:");
        System.out.println("Teléfono cliente: " + cliente.getTelefono());
        System.out.println("Nuevo total factura: $" + factura.getTotal());
    }
}

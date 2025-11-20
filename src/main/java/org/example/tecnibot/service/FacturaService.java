package org.example.tecnibot.service;

import org.example.tecnibot.*;
import org.example.tecnibot.dao.FacturaDAO;

public class FacturaService {
    private final FacturaDAO facturaDAO;

    public FacturaService(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }

    public void mostrarFactura(int idFactura) {
        try {
            Factura factura = facturaDAO.obtenerFacturaPorId(idFactura);
            if (factura != null) {
                Cliente cliente = factura.getCliente();
                Servicio servicio = factura.getServicio();
                Dispositivo dispositivo = servicio.getDispositivo();
                Tecnico tecnico = servicio.getTecnico();

                System.out.println("Factura ID: " + idFactura);
                System.out.println("Fecha: " + factura.getFecha());
                System.out.println("Cliente: " + cliente.getNombre());
                System.out.println("Dispositivo: " + dispositivo.getMarca() + " " + dispositivo.getModelo());
                System.out.println("Técnico: " + tecnico.getNombre());
                System.out.println("Componentes utilizados:");
                for (Componente c : servicio.getComponentesUtilizados()) {
                    System.out.println("- " + c.getNombre() + " (" + c.getDescripcion() + "): $" + c.getPrecio());
                }
                System.out.println("Total: $" + factura.getTotal());
            } else {
                System.out.println("Factura no encontrada.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
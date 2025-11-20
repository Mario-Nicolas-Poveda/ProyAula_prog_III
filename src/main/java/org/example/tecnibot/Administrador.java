package org.example.tecnibot;

public class Administrador extends Usuario{
    public Administrador(String nombre, String correo, String password){
        super(nombre, correo, password);
    }
    @Override
    public void mostrarOpciones(){
        System.out.println("1. Registrar tecnico");
        System.out.println("2. Agregar componente");
        System.out.println("3. Ver estadisticas");
    }
}

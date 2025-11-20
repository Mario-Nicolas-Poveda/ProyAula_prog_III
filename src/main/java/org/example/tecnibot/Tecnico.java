package org.example.tecnibot;

public class Tecnico extends Usuario{
    public Tecnico(String nombre, String correo, String password){
        super(nombre, correo, password);
    }
    @Override
    public void mostrarOpciones(){
        System.out.println("1. Registrar serivicio de reparacion");
        System.out.println("2. Marcar servicio como completado");
    }
}

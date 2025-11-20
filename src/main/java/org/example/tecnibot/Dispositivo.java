package org.example.tecnibot;

public class Dispositivo{
    private String tipo;
    private String marca;
    private String modelo;
    private Cliente cliente;

    public  Dispositivo(String tipo, String marca, String modelo, Cliente cliente){
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
        this.cliente = cliente;
    }

    public String getTipo(){
        return tipo;
    }
    public String getMarca(){
        return marca;
    }
    public String getModelo(){
        return modelo;
    }
    public Cliente getCliente(){
        return cliente;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
}

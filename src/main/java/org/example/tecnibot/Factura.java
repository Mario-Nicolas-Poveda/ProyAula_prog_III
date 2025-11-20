package org.example.tecnibot;

import java.time.LocalDate;

public class Factura{
    private Cliente cliente;
    private Servicio servicio;
    private LocalDate fecha;
    private double total;

    public Factura(Cliente cliente, Servicio servicio, LocalDate fecha, double total){
        this.cliente = cliente;
        this.servicio = servicio;
        this.fecha = fecha;
        this.total = total;
    }
    public Cliente getCliente() {
        return cliente;
    }
    public Servicio getServicio() {
        return servicio;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public double getTotal() {
        return total;
    }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public void setTotal(double total) {
        this.total = total;
    }
}

package org.example.tecnibot;

import java.util.List;
import java.util.ArrayList;

public class Servicio{
    private Dispositivo dispositivo;
    private Tecnico tecnico;
    private List<Componente> componentesUtilizados;
    private double costoManoObra;
    private boolean completado;

    public Servicio(Dispositivo dispositivo, Tecnico tecnico, double costoManoObra) {
        this.dispositivo = dispositivo;
        this.tecnico = tecnico;
        this.costoManoObra = costoManoObra;
        this.componentesUtilizados = new ArrayList<>();
        this.completado = false;
    }

    public void agregarComponente(Componente componente) {
        this.componentesUtilizados.add(componente);
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }
    public Tecnico getTecnico() {
        return tecnico;
    }
    public List<Componente> getComponentesUtilizados() {
        return componentesUtilizados;
    }
    public double getCostoManoObra() {
        return costoManoObra;
    }
    public boolean isCompletado() {
        return completado;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }
    public void setTecnico(Tecnico tecnico) {
        this.tecnico = tecnico;
    }
    public void setCostoManoObra(double costoManoObra) {
        this.costoManoObra = costoManoObra;
    }
    public void setCompletado(boolean completado) {
        this.completado = completado;
    }
}
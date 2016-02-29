package com.example.praxis.pruebasqlite.database.entities;

/**
 * Created by Praxis on 17/02/2016.
 */
public class HistoricoActividades {

    private int id;

    private String claveProyecto;
    private String claveActividad;
    private String actividad;
    private String descripcion;
    private int horasCapturadas;

    public HistoricoActividades(int id, String claveProyecto, String claveActividad, String actividad, String descripcion, int horasCapturadas) {
        this.id = id;
        this.claveProyecto = claveProyecto;
        this.claveActividad = claveActividad;
        this.actividad = actividad;
        this.descripcion = descripcion;
        this.horasCapturadas = horasCapturadas;
    }

    public HistoricoActividades() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClaveProyecto() {
        return claveProyecto;
    }

    public void setClaveProyecto(String claveProyecto) {
        this.claveProyecto = claveProyecto;
    }

    public String getClaveActividad() {
        return claveActividad;
    }

    public void setClaveActividad(String claveActividad) {
        this.claveActividad = claveActividad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getHorasCapturadas() {
        return horasCapturadas;
    }

    public void setHorasCapturadas(int horasCapturadas) {
        this.horasCapturadas = horasCapturadas;
    }
}

package com.example.praxis.pruebasqlite.database.dao.interfaces;

import com.example.praxis.pruebasqlite.database.entities.Tabla1;

import java.util.List;

/**
 * Created by Praxis on 11/02/2016.
 */
public interface InterfaceTabla1DAO {

    public abstract Tabla1 obtenerTablaPorID(int id);
    public abstract Tabla1 obtenerTablaPorNombre(String atributo1);
    public abstract void insertarTabla(Tabla1 datos);
    public abstract List<Tabla1> obtenerTodasTablas();
    public abstract void eliminarTabla(int id);
}

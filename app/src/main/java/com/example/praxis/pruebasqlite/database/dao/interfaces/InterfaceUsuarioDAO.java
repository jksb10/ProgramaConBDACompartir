package com.example.praxis.pruebasqlite.database.dao.interfaces;

import com.example.praxis.pruebasqlite.database.entities.Tabla1;
import com.example.praxis.pruebasqlite.database.entities.Usuario;

import java.util.List;

/**
 * Created by Praxis on 11/02/2016.
 */
public interface InterfaceUsuarioDAO {

    public abstract Usuario obtenerUsuarioPorID(int id);
    public abstract Usuario obtenerUsuarioPorNombre(String nombre);
    public abstract void insertarUsuario(Usuario datos);
    public abstract List<Usuario> obtenerTodosUsuarios();
    public abstract void eliminarUsuario(int id);
}

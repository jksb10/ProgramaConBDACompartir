package com.example.praxis.pruebasqlite.database.dao.implementaciones;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.praxis.pruebasqlite.database.contract.SQLHelper;
import com.example.praxis.pruebasqlite.database.contract.Tablas;
import com.example.praxis.pruebasqlite.database.contract.Tablas;
import com.example.praxis.pruebasqlite.database.dao.interfaces.InterfaceUsuarioDAO;
import com.example.praxis.pruebasqlite.database.dao.interfaces.InterfaceUsuarioDAO;
import com.example.praxis.pruebasqlite.database.entities.Usuario;
import com.example.praxis.pruebasqlite.database.entities.Usuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Praxis on 11/02/2016.
 */

public class UsuarioDAO implements InterfaceUsuarioDAO{

    private Context context;
    private SQLHelper sqlHelper;

    public UsuarioDAO(Context context){
        sqlHelper = new SQLHelper(context);
    }

    @Override
    public Usuario obtenerUsuarioPorID(int id) {
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Tablas.USUARIO.TABLE + " WHERE " +
                Tablas.USUARIO.ID+ " = " + id, null);
        Usuario Usuario = new Usuario();
        if (c.moveToFirst()) {
            do {
                Usuario.setId(id);
                Usuario.setNombre(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.NOMBRE)));
                Usuario.setApellidoPaterno(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.APELLIDO_PATERNO)));
                Usuario.setApellidoMaterno(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.APELLIDO_MATERNO)));
            } while (c.moveToNext());
        }
        db.close();
        return Usuario;

    }

    @Override
    public void insertarUsuario(Usuario datos) {
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Tablas.USUARIO.NOMBRE,datos.getNombre());
        cv.put(Tablas.USUARIO.APELLIDO_PATERNO,datos.getApellidoPaterno());
        cv.put(Tablas.USUARIO.APELLIDO_MATERNO,datos.getApellidoMaterno());
        db.insert(Tablas.USUARIO.TABLE,null,cv);
    }

    @Override
    public Usuario obtenerUsuarioPorNombre(String nombre) {
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Tablas.USUARIO.TABLE + " WHERE " +
                Tablas.USUARIO.NOMBRE+ " = " + nombre, null);
        Usuario Usuario = new Usuario();
        if (c.moveToFirst()) {
            do {
                Usuario.setId(c.getInt(c.getColumnIndexOrThrow(Tablas.USUARIO.ID)));
                Usuario.setNombre(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.NOMBRE)));
                Usuario.setApellidoPaterno(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.APELLIDO_PATERNO)));
                Usuario.setApellidoMaterno(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.APELLIDO_MATERNO)));
            } while (c.moveToNext());
        }
        db.close();
        return Usuario;
    }



    @Override
    public List<Usuario> obtenerTodosUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Tablas.USUARIO.TABLE, null);
        Usuario Usuario;
        while (c.moveToNext()) {
            do {
                Usuario = new Usuario();
                Usuario.setId(c.getInt(c.getColumnIndexOrThrow(Tablas.USUARIO.ID)));
                Usuario.setNombre(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.NOMBRE)));
                Usuario.setApellidoPaterno(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.APELLIDO_PATERNO)));
                Usuario.setApellidoMaterno(c.getString(c.getColumnIndexOrThrow(Tablas.USUARIO.APELLIDO_MATERNO)));
                usuarios.add(Usuario);
            } while (c.moveToNext());
        }
        db.close();
        return usuarios;

    }

    @Override
    public void eliminarUsuario(int id) {

    }
}
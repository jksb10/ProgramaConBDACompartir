package com.example.praxis.pruebasqlite.database.dao.implementaciones;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.praxis.pruebasqlite.database.contract.SQLHelper;
import com.example.praxis.pruebasqlite.database.contract.Tablas;
import com.example.praxis.pruebasqlite.database.dao.interfaces.InterfaceTabla1DAO;
import com.example.praxis.pruebasqlite.database.entities.Tabla1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Praxis on 11/02/2016.
 */

public class Tabla1DAO implements InterfaceTabla1DAO{

    private Context context;
    private SQLHelper sqlHelper;

    public Tabla1DAO (Context context){
        sqlHelper = new SQLHelper(context);
    }

    @Override
    public Tabla1 obtenerTablaPorID(int id) {
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Tablas.TABLA1.TABLE + " WHERE " +
                Tablas.TABLA1.ID+ " = " + id, null);
        Tabla1 tabla1 = new Tabla1();
        if (c.moveToFirst()) {
            do {
                tabla1.setId(id);
                tabla1.setAtributo1(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO1)));
                tabla1.setAtributo2(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO2)));
                tabla1.setAtributo3(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO3)));
                tabla1.setAtributo4(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO4)));
                tabla1.setAtributo5(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO5)));
                tabla1.setAtributo6(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO6)));
                tabla1.setAtributo7(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO7)));
                tabla1.setAtributo8(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO8)));
                tabla1.setAtributo9(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO9)));
                tabla1.setAtributo10(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO10)));
                tabla1.setAtributo11(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO11)));
                tabla1.setAtributo12(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO12)));
            } while (c.moveToNext());
        }
        db.close();
        return tabla1;

    }

    @Override
    public void insertarTabla(Tabla1 datos) {
        SQLiteDatabase db = sqlHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(Tablas.TABLA1.ATRIBUTO1,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO2,datos.getAtributo2());
        cv.put(Tablas.TABLA1.ATRIBUTO3,datos.getAtributo3());
        cv.put(Tablas.TABLA1.ATRIBUTO4,datos.getAtributo4());
        cv.put(Tablas.TABLA1.ATRIBUTO5,datos.getAtributo5());
        cv.put(Tablas.TABLA1.ATRIBUTO6,datos.getAtributo6());
        cv.put(Tablas.TABLA1.ATRIBUTO7,datos.getAtributo7());
        cv.put(Tablas.TABLA1.ATRIBUTO8,datos.getAtributo8());
        cv.put(Tablas.TABLA1.ATRIBUTO9,datos.getAtributo9());
        cv.put(Tablas.TABLA1.ATRIBUTO10,datos.getAtributo10());
        cv.put(Tablas.TABLA1.ATRIBUTO11,datos.getAtributo11());
        cv.put(Tablas.TABLA1.ATRIBUTO12,datos.getAtributo12());
        db.insert(Tablas.TABLA1.TABLE,null,cv);
    }

    @Override
    public Tabla1 obtenerTablaPorNombre(String atributo1) {
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Tablas.TABLA1.TABLE + " WHERE " +
                Tablas.TABLA1.ATRIBUTO1+ " = " + atributo1, null);
        Tabla1 tabla1 = new Tabla1();
        if (c.moveToFirst()) {
            do {
                tabla1.setId(c.getInt(c.getColumnIndexOrThrow(Tablas.TABLA1.ID)));
                tabla1.setAtributo1(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO1)));
                tabla1.setAtributo2(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO2)));
                tabla1.setAtributo3(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO3)));
                tabla1.setAtributo4(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO4)));
                tabla1.setAtributo5(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO5)));
                tabla1.setAtributo6(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO6)));
                tabla1.setAtributo7(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO7)));
                tabla1.setAtributo8(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO8)));
                tabla1.setAtributo9(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO9)));
                tabla1.setAtributo10(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO10)));
                tabla1.setAtributo11(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO11)));
                tabla1.setAtributo12(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO12)));
            } while (c.moveToNext());
        }
        db.close();
        return tabla1;
    }



    @Override
    public List<Tabla1> obtenerTodasTablas() {
        List<Tabla1> tablas = new ArrayList<>();
        SQLiteDatabase db = sqlHelper.getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + Tablas.TABLA1.TABLE, null);
        Tabla1 tabla1;
        while (c.moveToNext()) {
            do {
                tabla1 = new Tabla1();
                tabla1.setId(c.getInt(c.getColumnIndexOrThrow(Tablas.TABLA1.ID)));
                tabla1.setAtributo1(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO1)));
                tabla1.setAtributo2(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO2)));
                tabla1.setAtributo3(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO3)));
                tabla1.setAtributo4(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO4)));
                tabla1.setAtributo5(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO5)));
                tabla1.setAtributo6(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO6)));
                tabla1.setAtributo7(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO7)));
                tabla1.setAtributo8(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO8)));
                tabla1.setAtributo9(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO9)));
                tabla1.setAtributo10(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO10)));
                tabla1.setAtributo11(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO11)));
                tabla1.setAtributo12(c.getString(c.getColumnIndexOrThrow(Tablas.TABLA1.ATRIBUTO12)));
                tablas.add(tabla1);
            } while (c.moveToNext());
        }
        db.close();
        return tablas;

    }

    @Override
    public void eliminarTabla(int id) {

    }
}
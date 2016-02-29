package com.example.praxis.pruebasqlite.database.contract;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.lang.reflect.Field;

/**
 * Created by Praxis on 10/02/2016.
 */
public class SQLHelper extends SQLiteOpenHelper{

    public enum DB {
        CREAR_TABLA ("CREATE TABLE"),
        BORRAR_TABLA ("DROP TABLE IF EXISTS"),
        COMA (","),
        ESPACIO (" "),
        ABRIR_PARENTESIS ("("),
        CERRAR_PARENTESIS (")"),
        TABLA ("TABLE");
        private final String name;
        private DB(String s) {
            name = s;
        }
        public boolean equalsName(String otherName){
            return (otherName == null)? false:name.equals(otherName);
        }
        public String toString(){
            return name;
        }
    }

    public SQLHelper(Context context) {
        super(context, DB_NOMBRE, null, DB_VERSION);
    }


    private static final int DB_VERSION = 1;
    private static final String DB_NOMBRE = "Nombre";


    @Override
    public void onCreate(SQLiteDatabase db) {
        Class currentClass = null;
        currentClass = Tablas.class;
        Class[] classes = currentClass.getClasses();
        for ( Class c : classes){
            //getQuery(c);
            db.execSQL(getQuery(c));
        }
    }

    private String getQuery(Class currentClass){
        StringBuffer query = new StringBuffer();
        query.append(DB.CREAR_TABLA.toString()).append(DB.ESPACIO.toString());
        Field[] classFields = currentClass.getFields();
        Columna fieldColumn;
        try {
            Field field = currentClass.getDeclaredField(DB.TABLA.toString());
            query.append(field.get(null).toString().toLowerCase()).append(DB.ESPACIO.toString())
                    .append(DB.ABRIR_PARENTESIS.toString());

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        catch (IllegalAccessException ex) {
            ex.printStackTrace();
        }
        for (Field f : classFields){
            try {
                fieldColumn = f.getAnnotation(Columna.class);
                if (fieldColumn == null){
                    continue;
                }
                else{
                    query.append(DB.ESPACIO.toString()).append(f.get(null).toString()).append(DB.ESPACIO.toString())
                            .append(fieldColumn.atributo()).append(DB.COMA.toString());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        int n=query.lastIndexOf(DB.COMA.toString());
        if (query.lastIndexOf(DB.COMA.toString()) == query.length()-1){
            query.deleteCharAt(n);
        }
        query.append(DB.ESPACIO.toString()).append(DB.CERRAR_PARENTESIS.toString());
        System.out.println("-" + query.toString());
        Log.e("DATABASE", "-" + query.toString());
        System.out.println("******************************************");
        Log.e("DATABASE","******************************************");
        return query.toString();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Class currentClass = null;
        currentClass = Tablas.class;
        Class[] classes = currentClass.getClasses();
        StringBuffer query;
        for ( Class c : classes){
            query = new StringBuffer();
            query.append(DB.BORRAR_TABLA.toString()).append(DB.ESPACIO.toString());
            try {
                Field field = c.getDeclaredField(DB.TABLA.toString());
                query.append(field.get(null).toString().toLowerCase());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            catch (IllegalAccessException ex) {
                ex.printStackTrace();
            }
            db.execSQL(query.toString());
        }
        onCreate(db);
    }
}

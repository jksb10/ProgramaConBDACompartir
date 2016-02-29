package com.example.praxis.pruebasqlite.database.contract;

import android.provider.BaseColumns;

/**
 * Created by Praxis on 10/02/2016.
 */

public abstract class Tablas {

    private static final String LLAVE_PRIMARIA = "INTEGER PRIMARY KEY AUTOINCREMENT";
    private static final String TEXTO = "TEXT";

    public abstract class TABLA1 implements BaseColumns{
        public static final String TABLE ="tabla1";
        @Columna(atributo = LLAVE_PRIMARIA)
        public static final String ID = "_id";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO1= "atributo1";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO2= "atributo2";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO3= "atributo3";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO4= "atributo4";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO5= "atributo5";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO6= "atribut6";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO7= "atributo7";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO8= "atributo8";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO9 ="atributo9";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO10= "atributo10";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO11= "atributo11";
        @Columna(atributo = TEXTO)
        public static final String ATRIBUTO12= "atributo12";
    }

    public abstract class USUARIO implements BaseColumns{
        public static final String TABLE ="usuario";
        @Columna(atributo = LLAVE_PRIMARIA)
        public static final String ID = "_id";
        @Columna(atributo = TEXTO)
        public static final String NOMBRE= "atributo1";
        @Columna(atributo = TEXTO)
        public static final String APELLIDO_PATERNO= "atributo2";
        @Columna(atributo = TEXTO)
        public static final String APELLIDO_MATERNO= "atributo3";
    }


}

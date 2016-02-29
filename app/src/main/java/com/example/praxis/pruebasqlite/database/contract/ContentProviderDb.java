package com.example.praxis.pruebasqlite.database.contract;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

/**
 * Created by Praxis on 25/02/2016.
 */
public class ContentProviderDb extends ContentProvider{
    SQLHelper dbHelper ;
    public static final String AUTHORITY = "com.example.praxis.pruebasqlite/tabla1";//specific for our our app, will be specified in maninfed
    public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

    private static final String BD_NOMBRE = "Nombre";
    private static final int BD_VERSION = 1;
    private static final String TABLA_TABLA1 = "tabla1";
    private static final String TABLA_USUARIO = "usuario";

    //Necesario para UriMatcher
    private static final int TIPO_TABLA1 = 1;
    private static final int TIPO_USUARIO = 2;
    private static final UriMatcher uriMatcher;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI("com.example.praxis.pruebasqlite", "tabla1/tabla1", TIPO_TABLA1);
        uriMatcher.addURI("com.example.praxis.pruebasqlite", "tabla1/usuario", TIPO_USUARIO);
    }

    @Override
    public boolean onCreate() {
        dbHelper = new SQLHelper(getContext());
        return true;
    }

    @Override
    public int delete(Uri uri, String where, String[] args) {
        String table = getTableName(uri);
        SQLiteDatabase dataBase=dbHelper.getWritableDatabase();
        return dataBase.delete(table, where, args);
    }

    @Override
    public String getType(Uri arg0) {
        
        return "S";
    }


    @Override
    public Uri insert(Uri uri, ContentValues initialValues) {
        //String table = getTableName(uri);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        long value = database.insert(TABLA_TABLA1, null, initialValues);
        return Uri.withAppendedPath(CONTENT_URI, String.valueOf(value));
    }

    /*@Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        String table =getTableName(uri);
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        Cursor cursor =database.query(table, projection, selection, selectionArgs, null, null, sortOrder);
        return cursor;
    }*/

    @Override
    public Cursor query(Uri uri, String[] projection,
                        String selection, String[] selectionArgs, String sortOrder) {

        String tabla = null;
        if(uriMatcher.match(uri) == TIPO_TABLA1){
            tabla = TABLA_TABLA1;
        }

        else if(uriMatcher.match(uri) == TIPO_USUARIO){
            tabla = TABLA_USUARIO;
        }
        String where = selection;
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        Cursor c = db.query(tabla, projection, where,
                selectionArgs, null, null, sortOrder);
        return c;
    }


    @Override
    public int update(Uri uri, ContentValues values, String whereClause,
                      String[] whereArgs) {
        String table = getTableName(uri);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        return database.update(table, values, whereClause, whereArgs);
    }

    public static String getTableName(Uri uri){
        String value = uri.getPath();
        value = value.replace("/", "");//we need to remove '/'
        return value;
    }
}

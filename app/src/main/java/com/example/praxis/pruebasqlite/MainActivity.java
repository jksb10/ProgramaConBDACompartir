package com.example.praxis.pruebasqlite;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.praxis.pruebasqlite.database.contract.ContentProviderDb;
import com.example.praxis.pruebasqlite.database.contract.SQLHelper;
import com.example.praxis.pruebasqlite.database.contract.Tablas;
import com.example.praxis.pruebasqlite.database.dao.implementaciones.Tabla1DAO;
import com.example.praxis.pruebasqlite.database.dao.implementaciones.UsuarioDAO;
import com.example.praxis.pruebasqlite.database.dao.interfaces.InterfaceTabla1DAO;
import com.example.praxis.pruebasqlite.database.dao.interfaces.InterfaceUsuarioDAO;
import com.example.praxis.pruebasqlite.database.entities.Tabla1;
import com.example.praxis.pruebasqlite.database.entities.Usuario;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_main);
        SQLHelper sqlHelper = new SQLHelper(getApplicationContext());
        //sqlHelper.onUpgrade(sqlHelper.getWritableDatabase(), 0, 1);
        final int total = 10;
        InterfaceTabla1DAO interfaceTabla1DAO = new Tabla1DAO(this);
        InterfaceUsuarioDAO interfaceUsuarioDAO = new UsuarioDAO(this);
        Tabla1 tabla1;
        Usuario usuario;


        for (int n = 1 ; n <= total ; n++){
            tabla1 = new Tabla1("atributo1" + n,"atributo2" + n,"atributo3" + n,"atributo4" + n,"atributo5" + n,"atributo6" + n,
                    "atributo7" + n,"atributo8" + n,"atributo9" + n,"atributo10" + n,"atributo11" + n,"atributo12" + n);
        //    interfaceTabla1DAO.insertarTabla(tabla1);
        }



        for (int n = 1 ; n <= total ; n++){
            usuario = new Usuario("nombre" + n,"apellidoPaterno" + n,"apellidoMaterno" + n);
        //    interfaceUsuarioDAO.insertarUsuario(usuario);
        }


        //consultar();
    }

    private void consultar(){

        int n = 200;
        Tabla1 datos = new Tabla1("atributoNuevo" + n,"atributo200" + n,"atributo300" + n,"atributo4" + n,"atributo5" + n,"atributo6" + n,
                "atributo7" + n,"atributo8" + n,"atributo9" + n,"atributo10" + n,"atributo11" + n,"atributo12" + n);
        datos.setId(200);

        Uri clientesUri = ContentProviderDb.CONTENT_URI;

        ContentResolver cr = getContentResolver();

        ContentValues cv = new ContentValues();

        cv.put(Tablas.TABLA1.ATRIBUTO1,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO2,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO3,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO4,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO5,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO6,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO7,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO8,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO9,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO10,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO11,datos.getAtributo1());
        cv.put(Tablas.TABLA1.ATRIBUTO12,datos.getAtributo1());

        cr.insert(clientesUri, cv);      //Orden de los resultados

        //Cursor c = getContentResolver().query( Uri.parse("content://" + AUTHORITY + "/" + Tablas.TABLA1.TABLE), null,
        //      Tablas.TABLA1.ID + "= ?", new String[]{"4"}, null);



        InterfaceTabla1DAO interfaceTabla1DAO = new Tabla1DAO(this);
        for (Tabla1 t : interfaceTabla1DAO.obtenerTodasTablas()){
            Log.e("Prueba",t.getAtributo1());
        }

        Cursor c = cr.query(clientesUri,
                null, //Columnas a devolver
                null,       //Condición de la query
                null,       //Argumentos variables de la query
                null);      //Orden de los resultados

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

        Log.e("TAG: ", tabla1.getAtributo1());
        Log.e("TAG: ", tabla1.getAtributo2());
        Log.e("TAG: ", tabla1.getAtributo3());
        Log.e("TAG: ", tabla1.getAtributo4());
        Log.e("TAG: ", tabla1.getAtributo5());
        Log.e("TAG: ", tabla1.getAtributo6());
    }


    public void onSave(View view){
        Usuario usuario = new Usuario();
        usuario.setNombre(((EditText) findViewById(R.id.nombre)).getText().toString());
        usuario.setApellidoPaterno(((EditText) findViewById(R.id.apellidoPaterno)).getText().toString());
        usuario.setApellidoMaterno(((EditText) findViewById(R.id.apellidoMaterno)).getText().toString());
        InterfaceUsuarioDAO interfaceUsuarioDAO = new UsuarioDAO(this);
        interfaceUsuarioDAO.insertarUsuario(usuario);
    }
}

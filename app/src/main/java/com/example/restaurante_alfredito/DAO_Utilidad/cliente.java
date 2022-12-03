package com.example.restaurante_alfredito.DAO_Utilidad;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurante_alfredito.SERVICIOS.ConectarDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

public class cliente extends ConectarDB {


    private SQLiteDatabase db;
    Context context;


    public cliente(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }


    public long Registrar_cuenta(String nombre, String apellido, String dni, String telefono, String correo, String direccion, String usuario, String contrasena ){
        long id=0;
        try{
            db =new ConectarDB( context , GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();
            ContentValues registro= new ContentValues();
            registro.put("nombre",nombre);
            registro.put("apellido",apellido);
            registro.put("dni",dni);
            registro.put("telefono",telefono);
            registro.put("correo",correo);
            registro.put("direccion",direccion);
            registro.put("usuario",usuario);
            registro.put("contrasena",contrasena);
            id = db.insert(GlobalesApp.TBL_CLIENTE,null,registro);
            db.close();
        }catch (Exception e){
            e.toString();
        }
    return id;
    }




}

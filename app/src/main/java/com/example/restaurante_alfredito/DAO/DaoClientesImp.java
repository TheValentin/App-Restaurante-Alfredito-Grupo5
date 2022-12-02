package com.example.restaurante_alfredito.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurante_alfredito.dto.Clientes;
import com.example.restaurante_alfredito.dto.Motorizado;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.util.ArrayList;

public class DaoClientesImp implements  DaoClientes{

    private SQLiteDatabase db ;

    @Override
    public ArrayList<Clientes> ListarClientes(Context context) {

        ArrayList<Clientes> list  =  new ArrayList<>();
        Clientes M= null;
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        String cadSQL="select *  from clientes";

        Cursor c =db.rawQuery(cadSQL,null);
        StringBuilder sb = new StringBuilder();
        if (c!=null){
            if (c.moveToFirst()){
                do{
                    M = new Clientes ();
                    M.setIdclientes(c.getString(0));
                    M.setNombre(c.getString(1));
                    M.setApellido(c.getString(2));
                    M.setDni(c.getString(3));
                    M.setTelefono(c.getString(4));
                    M.setCorreo(c.getString(5));
                    M.setDireccion(c.getString(6));
                    M.setUsuario(c.getString(7));
                    M.setContrasena(c.getString(8));
                    list.add(M);
                }while (c.moveToNext());

            }
            c.close();




        }else {

        }

        db.close();
        return list;
    }
}

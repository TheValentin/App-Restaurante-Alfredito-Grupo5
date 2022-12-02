package com.example.restaurante_alfredito.DAO;

import static androidx.test.InstrumentationRegistry.getContext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurante_alfredito.dto.Motorizado;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.util.ArrayList;
import java.util.List;

public class DaoMotorizadoImp implements  DaoMotorizado  {


    private SQLiteDatabase db ;

    @SuppressLint("Range")
    @Override
    public ArrayList<Motorizado> ListarMotorizado(Context context) {

        ArrayList<Motorizado> list  =  new ArrayList<>();
        Motorizado M= null;
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        String cadSQL="select *  from motorizado";

        Cursor c =db.rawQuery(cadSQL,null);
        StringBuilder sb = new StringBuilder();
        if (c!=null){
            if (c.moveToFirst()){
                do{
                     M = new Motorizado();
                    M.setIdmotorizado(c.getString(0));
                    M.setNombre(c.getString(1));
                    M.setApellido(c.getString(2));
                    M.setDni(c.getString(3));
                    M.setTelefono(c.getString(4));
                    M.setUsuario(c.getString(6));
                    M.setContrasena(c.getString(7));

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

package com.example.restaurante_alfredito.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurante_alfredito.dto.Productos;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.util.ArrayList;

public class DaoProductosImp implements DaoProductos{
    private SQLiteDatabase db;

    @Override
    public ArrayList<Productos> ListarProductos(Context context) {
        ArrayList<Productos> list = new ArrayList<>();
        Productos P;
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();
        String cadSQL="select * from productos";
        Cursor c=db.rawQuery(cadSQL,null);
        if(c!=null){
            if(c.moveToFirst()){
                do{
                    P = new Productos();
                    P.setIdproducto(c.getString(0));
                    P.setNombre(c.getString(1));
                    P.setStock(c.getInt(2));
                    P.setCategoria(c.getString(3));
                    P.setPrecio(c.getDouble(4));
                    P.setImagen(c.getBlob(5));
                    list.add(P);
                }while(c.moveToNext());
            }
            c.close();
        }else{

        }
        db.close();
        return list;
    }
}

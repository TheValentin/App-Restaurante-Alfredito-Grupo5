package com.example.restaurante_alfredito.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurante_alfredito.dto.Administrador;
import com.example.restaurante_alfredito.dto.Producto;
import com.example.restaurante_alfredito.dto.Productos;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.util.ArrayList;

public class DaoProductoImp implements DaoProducto{

    private SQLiteDatabase db ;


    @Override
    public ArrayList<Producto> ListarProducto(Context context) {
        ArrayList<Producto> list  =  new ArrayList<>();
        Producto M= null;
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        String cadSQL="select *  from producto";

        Cursor c =db.rawQuery(cadSQL,null);
        StringBuilder sb = new StringBuilder();
        if (c!=null){
            if (c.moveToFirst()){
                do{
                    M = new Producto ();
                    M.setIdproducto(c.getString(0));
                    M.setNombre(c.getString(1));
                    M.setStock(c.getInt(2));
                    M.setCategoria(c.getString(3));
                    M.setPrecio(c.getDouble(4));
                    M.setImagen(c.getBlob(5));
                    list.add(M);
                }while (c.moveToNext());

            }
            c.close();




        }else {

        }

        db.close();
        return list;



    }

    @Override
    public String CrearProducto(Context context, Producto producto) {

        String mensaje = null;
        try {
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        ContentValues registro =  new ContentValues();
        registro.put("idproducto", producto.getIdproducto().toString());
        registro.put("nombre", producto.getNombre().toString());
        registro.put("stock", producto.getStock());
        registro.put("categoria", producto.getCategoria().toString());
        registro.put("precio", producto.getPrecio());
        registro.put("imagen ", producto.getImagen());

            long ctos =db.insert(GlobalesApp.TBL_PRODUCTO,null,registro);
            if (ctos == 0) {
                mensaje = "cero filas insertadas";
            }


            db.close();
    }  catch (SQLException ex){



    }
        return mensaje;
    }

    @Override
    public Producto BuscarProducto(Context context, String id) {
        Producto p = new  Producto();
        try {
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getReadableDatabase();
        String cadSQL="select *  from producto where idproducto = ?";

        String codigo= id;
        String parametro[]={""+codigo};
        Cursor c = db.rawQuery(cadSQL,parametro);

        if (c!=null){
            if (c.moveToFirst()){


                p.setIdproducto(c.getString(0));
                p.setNombre(c.getString(1));
                p.setStock(c.getInt(2));
                p.setCategoria(c.getString(3));
                p.setPrecio(c.getDouble(4));
                p.setImagen(c.getBlob(5));


            }else {

                return null;

            }
            c.close();

        }

        db.close();

        }  catch (SQLException ex){



        }



        return p;
    }

    @Override
    public String ActualizarProducto(Context context,Producto producto) {
        String mensaje = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD, null, GlobalesApp.VERSION).getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("idproducto", producto.getIdproducto().toString());
            registro.put("nombre", producto.getNombre().toString());
            registro.put("stock", producto.getStock());
            registro.put("categoria", producto.getCategoria().toString());
            registro.put("precio", producto.getPrecio());
            registro.put("imagen ", producto.getImagen());


            String parametro[] = {"" + producto.getIdproducto().toString()};
            long ctos=db.update(GlobalesApp.TBL_PRODUCTO, registro, "idproducto=?", parametro);

            if (ctos == 0) {
                mensaje = "cero filas Actualizadas";
            }

            db.close();
        }  catch (SQLException ex){



        }
        return mensaje;

    }



    @Override
    public String EliminarProducto(Context context, String id) {

        String mensaje = null;
        try{
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();
        String codigo= id;
        String parametro[]={""+codigo};
            long ctos = db.delete(GlobalesApp.TBL_PRODUCTO,"idproducto=?",parametro);
            if (ctos == 0) {
                mensaje = "cero filas insertadas";
            }

            db.close();
        } catch (SQLException ex){



        }
        return mensaje;
    }
}

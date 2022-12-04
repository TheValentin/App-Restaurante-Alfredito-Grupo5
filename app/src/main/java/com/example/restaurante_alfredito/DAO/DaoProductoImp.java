package com.example.restaurante_alfredito.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurante_alfredito.dto.Producto;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.util.ArrayList;

public class DaoProductoImp implements DaoProducto{

    private SQLiteDatabase db ;


    @Override
    public ArrayList<Producto> ListarProducto(Context context) {
        return null;
    }

    @Override
    public String CrearProducto(Context context, Producto producto) {

        String mensaje = null;
        try {
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        ContentValues registro =  new ContentValues();
        registro.put("idproducto", producto.getIdproducto().toString());
        registro.put("nombre", producto.getNombre().toString());
        registro.put("categoria", producto.getCategoria().toString());
        registro.put("precio", producto.getPrecio());
        registro.put("imagen ", producto.getImagen());

            long ctos =db.insert(GlobalesApp.TBL_PRODUCTO,null,registro);
            if (ctos == 0) {
                mensaje = "cero filas insertadas";
            }
    }  catch (SQLException ex){



    }
        return mensaje;
    }

    @Override
    public String ActualizarProducto(Producto producto) {
        return null;
    }

    @Override
    public String EliminarProducto(Context context, String id) {
        return null;
    }
}

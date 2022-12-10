package com.example.restaurante_alfredito.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurante_alfredito.dto.Clientes;
import com.example.restaurante_alfredito.dto.Detalle_pedido;
import com.example.restaurante_alfredito.dto.Pedido;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DaoDetallePedidoImp implements DaoDetallePedido {

    private SQLiteDatabase db;

    @Override
    public Detalle_pedido BuscarDetalleP(Context context, String id) {

        ArrayList<Detalle_pedido> list = new ArrayList<>();
        Detalle_pedido DP = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD, null, GlobalesApp.VERSION).getReadableDatabase();

            String cadSQL = "SELECT p.nombre,d.cantidad FROM detalle_pedido d " +
                    "INNER join producto p ON d.fkproducto=p.idproducto  where fkpedido=?";
            String codigo = id;
            String parametro[] = {"" + codigo};
            Cursor c = db.rawQuery(cadSQL, parametro);
            if (c != null) {
                if (c.moveToFirst()) {
                    DP.getProducto().setNombre(c.getString(0));
                    DP.setCantidad(c.getInt(1));

                    list.add(DP);
                } else {
                    return null;
                }
                c.close();
            }
            db.close();

        } catch (SQLException ex) {

        }
        return DP;
    }

    @Override
    public ArrayList<Detalle_pedido> ListarPedidos(Context context, String id ) {
        ArrayList<Detalle_pedido> list  =  new ArrayList<>();
        Detalle_pedido DP= null;
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        String cadSQL="SELECT p.nombre,d.cantidad FROM detalle_pedido d " +
                "INNER join producto p ON d.fkproducto=p.idproducto  where fkpedido=?";
        String codigo = id;
        String parametro[] = {"" + codigo};
        Cursor c = db.rawQuery(cadSQL, parametro);

        StringBuilder sb = new StringBuilder();
        if (c!=null){
            if (c.moveToFirst()){
                do{
                    DP = new Detalle_pedido();
                    DP.setNombreproducto(c.getString(0));
                    DP.setCantidad(c.getInt(1));
                    list.add(DP);
                }while (c.moveToNext());

            }
            c.close();
        }else {
        }
        db.close();
        return list;




    }
}
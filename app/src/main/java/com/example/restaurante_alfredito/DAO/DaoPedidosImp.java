package com.example.restaurante_alfredito.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurante_alfredito.dto.Detalle_pedido;
import com.example.restaurante_alfredito.dto.Pedido;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class DaoPedidosImp implements DaoPedidos {

    private SQLiteDatabase db ;

    @Override
    public ArrayList<Pedido> ListarPedidos(Context context) {
        return null;
    }

    @Override
    public String grabarPedido(Context context, Pedido res) {

        String mensaje = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

            ContentValues registro_pedido =  new ContentValues();

            SimpleDateFormat form2 =new SimpleDateFormat("dd/MM/yyyy"); //para darle fomato a la variable date

            registro_pedido.put("idpedido",res.getIdpedido());
            registro_pedido.put("fecha",form2.format(res.getFecha()));
            registro_pedido.put("estado", res.getEstado());
            registro_pedido.put("total",res.getTotal());
            registro_pedido.put("fkclientes",res.getFkclientes());
            registro_pedido.put("fkmotorizado",res.getFkmotorizado());




            long ctos =db.insert(GlobalesApp.DDL_TABLA_PEDIDO,null,registro_pedido);


            if (ctos == 0) {
                mensaje = "cero Empleados insertadas";
            }


            db.close();
        }  catch (SQLException ex){


        }
        return mensaje;


    }

    @Override
    public String grabarPedido_detalle(Context context, Pedido res, Detalle_pedido det) {


        String mensaje = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

            ContentValues registro_pedido =  new ContentValues();

            SimpleDateFormat form2 =new SimpleDateFormat("dd/MM/yyyy"); //para darle fomato a la variable date

            registro_pedido.put("fkpedido",res.getIdpedido());
            registro_pedido.put("fkproducto",det.getProducto().getIdproducto());
            registro_pedido.put("cantidad",det.getCantidad());

            long ctos =db.insert(GlobalesApp.DDL_TABLA_DETALLE_PEDIDO,null,registro_pedido);


            if (ctos == 0) {
                mensaje = "cero Empleados insertadas";
            }


            db.close();
        }  catch (SQLException ex){


        }
        return mensaje;



    }
}

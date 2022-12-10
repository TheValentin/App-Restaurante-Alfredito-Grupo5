package com.example.restaurante_alfredito.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.restaurante_alfredito.dto.Detalle_pedido;
import com.example.restaurante_alfredito.dto.Pedido;
import com.example.restaurante_alfredito.dto.Producto;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

public class DaoPedidosImp implements DaoPedidos {

    private SQLiteDatabase db ;

    ArrayList<String> listaInformacion;
    ArrayList<Pedido> list  =  new ArrayList<>();

    @Override
    public ArrayList<Pedido> ListarPedidos(Context context) {
        ArrayList<Pedido> list  =  new ArrayList<>();
        Pedido P= null;
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        String cadSQL="SELECT p.idpedido,c.nombre,p.fecha,p.total,p.estado FROM pedido p " +
                "INNER JOIN clientes c on p.fkclientes=c.idclientes where p.estado='PENDIENTE'";

        Cursor c =db.rawQuery(cadSQL,null);
        StringBuilder sb = new StringBuilder();
        if (c!=null){
            SimpleDateFormat form2 =new SimpleDateFormat("dd/MM/yyyy");
            if (c.moveToFirst()){
                do{
                    P = new Pedido ();
                    P.setIdpedido(c.getString(0));
                    P.setFkclientes(c.getString(1));
                    try {
                        P.setFecha(form2.parse(c.getString(2)));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    P.setTotal(c.getDouble(3));
                    P.setEstado(c.getString(4));
                    list.add(P);
                }while (c.moveToNext());

            }
            c.close();
        }else {
        }
        db.close();
        return list;
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




            long ctos =db.insert(GlobalesApp.TBL_PEDIDO,null,registro_pedido);


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

            long ctos =db.insert(GlobalesApp.TBL_DETALLE_PEDIDO,null,registro_pedido);


            if (ctos == 0) {
                mensaje = "cero Empleados insertadas";
            }


            db.close();
        }  catch (SQLException ex){


        }
        return mensaje;



    }

    @Override
    public String ActualizarEstado(Context context, String id) {
        String mensaje = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD, null, GlobalesApp.VERSION).getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("estado", "ATENDIDO");


            String parametro[] = {"" + id};
            long ctos=db.update(GlobalesApp.TBL_PEDIDO, registro, "idpedido=?", parametro);

            if (ctos == 0) {
                mensaje = "cero filas Actualizadas";
            }

            db.close();
        }  catch (SQLException ex){



        }
        return mensaje;

    }
}

package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoProductoImp;
import com.example.restaurante_alfredito.dto.Detalle_pedido;
import com.example.restaurante_alfredito.dto.Pedido;
import com.example.restaurante_alfredito.dto.Producto;

import java.util.ArrayList;

public class ServicioPedidoImp implements  ServicioPedido {


    private Pedido ped = new Pedido();

    @Override
    public ArrayList agregarPedido(Context context, String num, String cantidad) {

        Producto vue = (Producto) new DaoProductoImp().BuscarProducto(context,num);

        ped.agregar(vue, Integer.parseInt(cantidad));

        ArrayList lista=new ArrayList();
        for(int i=0;i< ped.getCesta().size();i++){
            Detalle_pedido lin=( Detalle_pedido )ped.getCesta().get(i);
            Object[]fil=new Object[5];
            fil[0]=lin.getProducto().getNombre();
            fil[1]=lin.getProducto().getPrecio();
            fil[2]=lin.getProducto().getImagen();
            fil[3]=lin.getCantidad();
            fil[4]=lin.getImporte();
            lista.add(fil);
        }
        return lista;

    }

    @Override
    public ArrayList quitarPedido(String num) {


        ped.quitar(num);

        ArrayList lista=new ArrayList();
        for(int i=0;i< ped.getCesta().size();i++){
            Detalle_pedido lin=( Detalle_pedido )ped.getCesta().get(i);
            Object[]fil=new Object[5];
            fil[0]=lin.getProducto().getNombre();
            fil[1]=lin.getProducto().getPrecio();
            fil[2]=lin.getProducto().getImagen();
            fil[3]=lin.getCantidad();
            fil[4]=lin.getImporte();
            lista.add(fil);
        }
        return lista;
    }



}
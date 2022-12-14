package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoPedidosImp;
import com.example.restaurante_alfredito.DAO.DaoProductoImp;
import com.example.restaurante_alfredito.dto.Detalle_pedido;
import com.example.restaurante_alfredito.dto.Pedido;
import com.example.restaurante_alfredito.dto.Producto;

import java.util.ArrayList;
import java.util.Date;

public class ServicioPedidoImp implements  ServicioPedido {


    public Pedido ped ;


    public ServicioPedidoImp(){
        ped = new Pedido();
    }


    @Override
    public String Obtener_codigo_audo_Pedido(Context context) {
        String numRes="";

        for (int i = 0; i < new DaoPedidosImp().ListarPedidos(context).size(); i++) {
            Pedido res=(Pedido )new DaoPedidosImp().ListarPedidos(context).get(i);
            numRes=res.getIdpedido();
        }
        String numResStr=numRes.substring(0, 1);  // captura el p
        String numResInt=numRes.substring(3);  //2 en adelante
        String numGen=String.valueOf(Integer.parseInt(numResInt)+1);
        while(numGen.length()<4){   // por  los 4 digitos    lenaremos los 0000
            numGen="0"+numGen;
        }
        return numResStr+numGen;
    }

    @Override
    public String Grabar_pedido(Context context, String num_res, String num_cliente, String total) {
         ped.setIdpedido(num_res);
        ped.setEstado("PENDIENTE");
        Date fecha_actual= new Date();
        ped.setFecha(fecha_actual);
        ped.setTotal(Double.parseDouble(total));
        ped.setFkclientes(num_cliente);
        ped.setFkmotorizado(null);
        String msg= new DaoPedidosImp().grabarPedido(context,ped);

        for(int i=0;i<ped.getCesta().size();i++){
            Detalle_pedido detalle_pedido = (Detalle_pedido) ped.getCesta().get(i);
            msg=new DaoPedidosImp().grabarPedido_detalle(context,ped, detalle_pedido);

        }

        return null;
    }

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
    public ArrayList listarPedido(Context context) {

        ArrayList  lis=new DaoPedidosImp().ListarPedidos(context);
        if (lis!=null) {
            ArrayList lista=new ArrayList();
            for (int i = 0; i <lis.size(); i++) {
                Pedido  p=(Pedido)lis.get(i);
                Object[] fil = new Object[6];
                fil[0] = p.getIdpedido();

                fil[1] = p.getFecha();

                fil[2] = p.getEstado();
                fil[3] = p.getTotal();
                fil[4] = p.getFkclientes();
                fil[5] = p.getFkmotorizado();
                lista.add(fil);

            }
            return lista;
        }

        return null;

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

    @Override
    public String ActualizarEstado(Context context, String id) {

        String msg=new DaoPedidosImp().ActualizarEstado(context,id);
        if (msg==null) {
            msg="Producto Actualizado";
        }
        return msg;
    }



}

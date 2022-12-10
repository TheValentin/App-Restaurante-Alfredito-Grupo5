package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoDetallePedidoImp;
import com.example.restaurante_alfredito.dto.Detalle_pedido;

import java.util.ArrayList;

public class ServicioDetallePedidoImp implements ServicioDetallePedido {


    @Override
    public ArrayList listarPedido(Context context, String id) {

        ArrayList  lis=new DaoDetallePedidoImp().ListarPedidos(context,id);
        if (lis!=null) {
            ArrayList lista=new ArrayList();
            for (int i = 0; i <lis.size(); i++) {
                Detalle_pedido dp=(Detalle_pedido) lis.get(i);
                Object[] fil = new Object[2];
                fil[0] = dp.getNombreproducto();
                fil[1] = dp.getCantidad();
                lista.add(fil);

            }
            return lista;
        }

        return null;
    }
}

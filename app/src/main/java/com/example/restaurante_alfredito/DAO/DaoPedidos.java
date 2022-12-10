package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Detalle_pedido;
import com.example.restaurante_alfredito.dto.Pedido;

import java.util.ArrayList;

public interface DaoPedidos {

    ArrayList<Pedido> ListarPedidos(Context context);

    public String grabarPedido(Context context, Pedido res);

    public String grabarPedido_detalle(Context context, Pedido res, Detalle_pedido det);

}

package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Detalle_pedido;

import java.util.ArrayList;

public interface DaoDetallePedido {

    Detalle_pedido BuscarDetalleP (Context context, String id);

    ArrayList<Detalle_pedido> ListarPedidos(Context context, String id);
}

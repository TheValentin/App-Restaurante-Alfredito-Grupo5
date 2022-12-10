package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Detalle_pedido;
import com.example.restaurante_alfredito.dto.Pedido;

import java.util.ArrayList;

public interface ServicioPedido {
    ArrayList listarPedido(Context context);

    ArrayList agregarPedido(Context context, String num, String cantidad);

    ArrayList quitarPedido(String num);

    public String Obtener_codigo_audo_Pedido(Context context);

    public String Grabar_pedido(Context context, String num_res, String num_cliente, String total);

    String ActualizarEstado(Context context, String id);

}

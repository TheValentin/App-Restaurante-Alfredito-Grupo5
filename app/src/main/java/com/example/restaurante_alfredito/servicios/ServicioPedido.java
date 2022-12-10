package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import java.util.ArrayList;

public interface ServicioPedido {
    ArrayList listarPedido(Context context);

    ArrayList agregarPedido(Context context, String num, String cantidad);

    ArrayList quitarPedido(String num);
}

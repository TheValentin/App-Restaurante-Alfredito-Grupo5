package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import java.util.ArrayList;

public interface ServicioDetallePedido {
    ArrayList listarPedido(Context context, String id);
}

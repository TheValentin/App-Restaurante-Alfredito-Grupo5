package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Pedido;

import java.util.ArrayList;

public interface DaoPedidos {
    ArrayList<Pedido> ListarPedidos (Context context);
}

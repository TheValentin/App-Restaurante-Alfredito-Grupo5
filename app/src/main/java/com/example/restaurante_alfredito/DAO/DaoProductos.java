package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Productos;

import java.util.ArrayList;

public interface DaoProductos {
    ArrayList<Productos> ListarProductos (Context context);
}

package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Producto;

import java.util.ArrayList;

public interface DaoProducto {

    ArrayList<Producto> ListarProducto(Context context);

    String CrearProducto(Context context, Producto  producto);


    String ActualizarProducto(Producto producto);

    String EliminarProducto(Context context,  String  id);


}

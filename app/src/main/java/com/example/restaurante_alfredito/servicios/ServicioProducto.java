package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import java.util.ArrayList;

public interface ServicioProducto {
    ArrayList listarProducto(Context context);

    String grabarProducto(Context context, String idproducto, String  nombre , int stock , String categoria, double precio, byte[] imagen);

    Object[] Buscar_Producto(Context context, String cod);

    String ActualizarProducto(Context context, String idproducto, String  nombre , int stock , String categoria, double precio, byte[] imagen);

    String eliminarProducto(Context context, String cod);
}

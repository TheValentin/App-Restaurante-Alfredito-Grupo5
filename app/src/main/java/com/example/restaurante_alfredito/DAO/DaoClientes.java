package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Clientes;
import com.example.restaurante_alfredito.dto.Motorizado;
import com.example.restaurante_alfredito.dto.Producto;

import java.util.ArrayList;

public interface DaoClientes {
    ArrayList<Clientes> ListarClientes(Context context);
    String CrearCliente(Context context, Clientes clientes );

    String ActualizarClientes(Context context, Clientes clientes);

    public Clientes BuscarClientes(Context context, String id);
}

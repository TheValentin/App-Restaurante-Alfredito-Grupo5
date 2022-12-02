package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Clientes;
import com.example.restaurante_alfredito.dto.Motorizado;

import java.util.ArrayList;

public interface DaoClientes {
    ArrayList<Clientes> ListarClientes(Context context);
}

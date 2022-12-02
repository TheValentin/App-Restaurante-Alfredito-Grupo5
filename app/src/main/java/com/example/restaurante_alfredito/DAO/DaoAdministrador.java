package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Administrador;
import com.example.restaurante_alfredito.dto.Clientes;

import java.util.ArrayList;

public interface DaoAdministrador {

    ArrayList<Administrador> ListarAdministrador(Context context);
}

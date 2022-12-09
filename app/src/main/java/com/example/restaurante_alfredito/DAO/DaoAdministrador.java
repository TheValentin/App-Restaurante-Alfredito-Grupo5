package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Administrador;

import java.util.ArrayList;

public interface DaoAdministrador {

    ArrayList<Administrador> ListarAdministrador(Context context);

    String CrearRegistroAdmin(Context context, Administrador administrador);
    String ActualizarAdmin(Context context, Administrador administrador);

    public Administrador BuscarAdmin(Context context, String  id);

}

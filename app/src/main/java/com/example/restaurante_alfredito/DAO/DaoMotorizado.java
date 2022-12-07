package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Motorizado;
import com.example.restaurante_alfredito.dto.Producto;

import java.util.ArrayList;
import java.util.List;

public interface DaoMotorizado {

    ArrayList<Motorizado> ListarMotorizado(Context context);

    String CrearRegistroEmpleado(Context context, Motorizado motorizado);
    String ActualizarEmpleado(Context context, Motorizado motorizado);

    public Motorizado BuscarMotorizado(Context context, String  id);

}

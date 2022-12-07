package com.example.restaurante_alfredito.DAO;

import android.content.Context;

import com.example.restaurante_alfredito.dto.Motorizado;

import java.util.ArrayList;
import java.util.List;

public interface DaoMotorizado {

    ArrayList<Motorizado> ListarMotorizado(Context context);

    String CrearRegistroEmpleado(Context context, Motorizado motorizado);

}

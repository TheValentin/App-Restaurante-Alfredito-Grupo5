package com.example.restaurante_alfredito.servicios;

import android.content.Context;

public interface ServicioMotorizado {
    public Object[] validarMotorizado(Context context, String usu, String pas);

    String RegistrarEmpleado(Context context, String idEmpleado, String nombre, String apellido, String dni, String telefono, byte[] imagen, String usuario, String contrasena);
    String ActualizarEmpleado(Context context, String idEmpleado, String nombre, String apellido, String dni, String telefono, byte[] imagen, String usuario, String contrasena);

    Object[] Buscar_Motorizado(Context context, String cod);
}

package com.example.restaurante_alfredito.servicios;

import android.content.Context;

public interface ServicioAdministrador {
    public Object[] validarAdministrador(Context context, String usu, String pas);

    String RegistrarAdmin(Context context, String idAdmin, String nombre, String apellido, String dni, String telefono, byte[] imagen, String usuario, String contrasena);
    String ActualizarAdmin(Context context, String idAdmin, String nombre, String apellido, String dni, String telefono, byte[] imagen, String usuario, String contrasena);

    Object[] Buscar_Admin(Context context, String cod);
}

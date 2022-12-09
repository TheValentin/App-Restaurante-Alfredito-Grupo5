package com.example.restaurante_alfredito.servicios;

import android.content.Context;

public interface ServicioClientes {

    public Object[] validarClientes(Context context, String usu, String pas);

    String RegistrarUsuariosCLientes(Context context, String nombre, String apellido, String telefno, String dni, String correo, String usuario, String contrasena, String direccion, String idUsuario );
    String ActualizarClientes(Context context, String idclientes, String nombre, String apellido, String dni, String telefono, String correo, String direccion, String usuario, String contrasena);
    Object[] Buscar_Clientes(Context context, String cod);
}

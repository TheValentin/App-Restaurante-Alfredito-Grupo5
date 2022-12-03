package com.example.restaurante_alfredito.dto;

public class Administrador {

    private String idadmin  ;
    private String  nombre  ;
    private String  apellido ;
    private String  dni  ;
    private String telefono;
    private byte[] foto  ;
    private String usuario ;
    private String contrasena ;

    public Administrador() {

    }

    public Administrador(String idadmin, String nombre, String apellido, String dni, String telefono, byte[] foto, String usuario, String contrasena) {
        this.idadmin = idadmin;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.foto = foto;
        this.usuario = usuario;
        this.contrasena = contrasena;
    }

    public String getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}

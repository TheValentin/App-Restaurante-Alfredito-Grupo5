package com.example.restaurante_alfredito;

public class Productos {

    int imagen ;
    String nombre;
    String descrip;



    String cantidad ;

    public Productos(int imagen, String nombre, String descrip) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descrip = descrip;
    }


    public Productos(int imagen, String nombre, String descrip,String cantidad) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descrip = descrip;
        this.cantidad=cantidad;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

}

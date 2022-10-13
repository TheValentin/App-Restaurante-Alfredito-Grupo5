package com.example.restaurante_alfredito;

public class Productos {

    int imagen ;
    String nombre;
    String descrip;

    public Productos(int imagen, String nombre, String descrip) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descrip = descrip;
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


}

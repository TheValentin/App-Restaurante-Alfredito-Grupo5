package com.example.restaurante_alfredito;

public class Productos {
/*
    int imagen ;
    */
    byte[] imagen;
    String nombre;
    String descrip;
/*
    public Productos(int imagen, String nombre, String descrip) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descrip = descrip;
    }
*/
/*
    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }


*/

    public Productos(byte[] imagen, String nombre, String descrip) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descrip = descrip;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
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

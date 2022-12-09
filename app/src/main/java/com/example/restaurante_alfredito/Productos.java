package com.example.restaurante_alfredito;

public class Productos {
/*
    int imagen ;
    */
    byte[] imagen;
    String nombre;
    String descrip;
    String descrip_det;

    String importe ;

    String [] opciones;

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

    public Productos(byte[] imagen, String nombre, String descrip,String descrip_det,String [] opciones) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descrip = descrip;
        this.descrip_det=descrip_det;
        this.opciones=opciones;
    }
    public Productos(byte[] imagen, String nombre, String descrip,String descrip_det,String importe) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.descrip = descrip;
        this.descrip_det=descrip_det;
        this.importe=importe;

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


    public String getDescrip_det() {
        return descrip_det;
    }

    public void setDescrip_det(String descrip_det) {
        this.descrip_det = descrip_det;
    }

    public String getImporte() {
        return importe;
    }

    public void setImporte(String importe) {
        this.importe = importe;
    }

    public String[] getOpciones() {
        return opciones;
    }

    public void setOpciones(String[] opciones) {
        this.opciones = opciones;
    }
}

package com.example.restaurante_alfredito.dto;

public class Producto {

    private String  idproducto  ;
    private String  nombre  ;
    private int  stock  ;
    private String  categoria  ;
    private double precio ;
    private byte[]  imagen   ;

    public Producto() {

    }

    public Producto(String idproducto, String nombre, int stock, String categoria, double precio, byte[] imagen) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.stock = stock;
        this.categoria = categoria;
        this.precio = precio;
        this.imagen = imagen;
    }

    public String getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(String idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }
}

package com.example.restaurante_alfredito.dto;

public class Detalle_pedido {
    private Producto producto;
    private int cantidad;
    private String fkproducto;
    private String nombreproducto;

    public String getNombreproducto() {
        return nombreproducto;
    }

    public void setNombreproducto(String nombreproducto) {
        this.nombreproducto = nombreproducto;
    }

    public Detalle_pedido(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Detalle_pedido(Producto producto, int cantidad, String fkproducto) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.fkproducto = fkproducto;
    }

    public String getFkproducto() {
        return fkproducto;
    }

    public void setFkproducto(String fkproducto) {
        this.fkproducto = fkproducto;
    }

    public Detalle_pedido() {

    }

    public Producto getProducto() {return producto;
    }

    public void setProducto(Producto producto) {this.producto = producto;
    }

    public int getCantidad() {return cantidad;
    }

    public void setCantidad(int cantidad) {this.cantidad = cantidad;
    }

    public double getImporte(){return producto.getPrecio()*cantidad;
    }
}

package com.example.restaurante_alfredito;

public class Pedidos {

    String fecha;
    String codigo;
    String estado;
    String cliente;
    String total;

    public Pedidos(String fecha, String codigo, String estado, String cliente, String total) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.estado = estado;
        this.cliente = cliente;
        this.total = total;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTotal() { return total; }

    public void setTotal(String total) { this.total = total; }
}

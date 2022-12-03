package com.example.restaurante_alfredito.dto;

import java.util.Date;

public class Pedido {
    private String idpedido;
    private Date fecha;
    private String estado;
    private double total;

    public Pedido() {
    }

    public Pedido(String idpedido, Date fecha, String estado, double total) {
        this.idpedido = idpedido;
        this.fecha = fecha;
        this.estado = estado;
        this.total = total;
    }

    public String getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(String idpedido) {
        this.idpedido = idpedido;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}

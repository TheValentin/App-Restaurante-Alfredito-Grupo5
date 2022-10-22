package com.example.restaurante_alfredito;

public class PedidosCliente {

    String fecha;
    String codigo;
    String estado;

    public PedidosCliente(String fecha, String codigo, String estado) {
        this.fecha = fecha;
        this.codigo = codigo;
        this.estado = estado;
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

}

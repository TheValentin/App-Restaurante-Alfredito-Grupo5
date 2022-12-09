package com.example.restaurante_alfredito.dto;

import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private String idpedido;
    private Date fecha;
    private String estado;
    private double total;

    private String fkclientes;
    private String fkmotorizado;


    ArrayList Cesta;

    public Pedido() {
        Cesta=new ArrayList();
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

    public String getFkclientes() {
        return fkclientes;
    }

    public void setFkclientes(String fkclientes) {
        this.fkclientes = fkclientes;
    }

    public String getFkmotorizado() {
        return fkmotorizado;
    }

    public void setFkmotorizado(String fkmotorizado) {
        this.fkmotorizado = fkmotorizado;
    }

    public ArrayList getCesta() {
        return Cesta;
    }

    public void setCesta(ArrayList cesta) {
        Cesta = cesta;
    }

    public void agregar(Producto pro, int cantidad){

Detalle_pedido detalle_pedido= new Detalle_pedido(pro,cantidad);

        Cesta.add(detalle_pedido);


    }
    public void quitar(String num){

        for (int i = 0; i < Cesta.size(); i++) {
            Detalle_pedido lin=(Detalle_pedido)Cesta.get(i);
            if (lin.getProducto().getIdproducto().equals(num) || lin.getProducto().getNombre().equals(num)) {

                Cesta.remove(i);

            }
        }
    }



    }



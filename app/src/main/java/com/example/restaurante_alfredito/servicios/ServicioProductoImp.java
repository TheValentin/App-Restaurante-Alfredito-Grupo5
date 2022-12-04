package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoProducto;
import com.example.restaurante_alfredito.DAO.DaoProductoImp;
import com.example.restaurante_alfredito.dto.Producto;

public class ServicioProductoImp implements  ServicioProducto{



    @Override
    public String grabarProducto(Context context,String idproducto, String nombre, int stock, String categoria, double precio, byte[] imagen) {

        Producto p= new Producto();

        p.setIdproducto(idproducto);
        p.setNombre(nombre);
        p.setStock(stock);
        p.setCategoria(categoria);
        p.setPrecio(precio);
        p.setImagen(imagen);

        String msg=new DaoProductoImp().CrearProducto(context,p);
        if (msg==null) {
            msg="Producto Grabado";
        }
        return msg;
    }
}

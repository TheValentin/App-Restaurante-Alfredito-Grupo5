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

    @Override
    public Object[] Buscar_Producto(Context context, String cod) {
Producto p = new DaoProductoImp().BuscarProducto(context, cod);
        if (p!=null) {
            Object[] fil = new Object[6];
            fil[0] = p.getIdproducto();
            fil[1] = p.getNombre();
            fil[2] = p.getStock();
            fil[3] = p.getCategoria();
            fil[4] = p.getPrecio();
            fil[5] = p.getImagen();
            return fil;
        }

        return null;
    }

    @Override
    public String ActualizarProducto(Context context, String idproducto, String nombre, int stock, String categoria, double precio, byte[] imagen) {
        Producto p= new Producto();

        p.setIdproducto(idproducto);
        p.setNombre(nombre);
        p.setStock(stock);
        p.setCategoria(categoria);
        p.setPrecio(precio);
        p.setImagen(imagen);

        String msg=new DaoProductoImp().ActualizarProducto(context,p);
        if (msg==null) {
            msg="Producto Actualizado";
        }
        return msg;
    }

    @Override
    public String eliminarProducto(Context context, String cod) {

        String msg=new DaoProductoImp().EliminarProducto(context,cod);
        if(msg==null){
            msg="Producto Eliminado";
        }
        return msg;
    }
}

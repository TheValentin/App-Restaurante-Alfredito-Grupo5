package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoClientesImp;
import com.example.restaurante_alfredito.DAO.DaoMotorizadoImp;
import com.example.restaurante_alfredito.DAO.DaoProductoImp;
import com.example.restaurante_alfredito.dto.Clientes;
import com.example.restaurante_alfredito.dto.Motorizado;

import java.util.ArrayList;

public class ServicioClientesImp implements  ServicioClientes{
    @Override
    public Object[] validarClientes(Context context, String usu, String pas) {
        ArrayList lis=new DaoClientesImp().ListarClientes(context);


        if (lis!=null) {
            for (int i = 0; i < lis.size(); i++) {
                Clientes p = (Clientes) lis.get(i);


                if (p.getUsuario().equals(usu) && p.getContrasena().equals(pas)) {
                    Object[]fil=new Object[2];
                    fil[0]=p.getIdclientes();
                    fil[1]=p.getApellido()+" "+p.getNombre();
                    return fil;
                }
            }


        }
        return null;
    }

    @Override
    public String RegistrarUsuariosCLientes(Context context, String nombre, String apellido, String telefno, String dni, String correo, String usuario, String contrasena, String direccion, String idUsuario) {

        Clientes c=new Clientes();

        c.setIdclientes(idUsuario);
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setTelefono(telefno);
        c.setDni(dni);
        c.setCorreo(correo);
        c.setUsuario(usuario);
        c.setContrasena(contrasena);
        c.setDireccion(direccion);


        String msg=new DaoClientesImp().CrearCliente(context,c);
        if (msg==null) {
            msg="Cliente Registrado";
        }
        return msg;
    }
}

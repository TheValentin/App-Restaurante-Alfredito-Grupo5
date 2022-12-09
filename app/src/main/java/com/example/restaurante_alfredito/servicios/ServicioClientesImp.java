package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoClientesImp;
import com.example.restaurante_alfredito.DAO.DaoMotorizadoImp;
import com.example.restaurante_alfredito.dto.Clientes;

import java.util.ArrayList;

public class ServicioClientesImp implements  ServicioClientes{
    @Override
    public Object[] validarClientes(Context context, String usu, String pas) {
        ArrayList lis=new DaoClientesImp().ListarClientes(context);


        if (lis!=null) {
            for (int i = 0; i < lis.size(); i++) {
                Clientes p = (Clientes) lis.get(i);


                if (p.getUsuario().equals(usu) && p.getContrasena().equals(pas)) {
                    Object[]fil=new Object[9];
                    fil[0]=p.getIdclientes();
                    fil[1]=p.getNombre();
                    fil[2]=p.getApellido();
                    fil[3]=p.getDni();
                    fil[4]=p.getTelefono();
                    fil[5]=p.getCorreo();
                    fil[6]=p.getDireccion();
                    fil[7]=p.getUsuario();
                    fil[8]=p.getContrasena();
                    return fil;
                }
            }


        }
        return null;
    }

    @Override
    public String RegistrarUsuariosCLientes(Context context, String nombre, String apellido, String telefono, String dni, String correo, String usuario, String contrasena, String direccion, String idUsuario) {

        Clientes c=new Clientes();

        c.setIdclientes(idUsuario);
        c.setNombre(nombre);
        c.setApellido(apellido);
        c.setTelefono(telefono);
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

    @Override
    public String ActualizarClientes(Context context, String idCliente, String nombre, String apellido, String dni, String telefono, String correo, String direccion, String usuario, String contrasena) {
        Clientes m = new Clientes();

        m.setIdclientes(idCliente);
        m.setNombre(nombre);
        m.setApellido(apellido);
        m.setDni(dni);
        m.setTelefono(telefono);
        m.setCorreo(correo);
        m.setDireccion(direccion);
        m.setUsuario(usuario);
        m.setContrasena(contrasena);

        String msg = new DaoClientesImp().ActualizarClientes(context, m);
        if (msg == null) {
            msg = "Cliente Actualizado";
        }
        return msg;

    }

    @Override
    public Object[] Buscar_Clientes(Context context, String cod) {

        Clientes m = new DaoClientesImp().BuscarClientes(context, cod);
        if (m != null) {
            Object[] fil = new Object[8];
            fil[0] = m.getIdclientes();
            fil[1] = m.getNombre();
            fil[2] = m.getApellido();
            fil[3] = m.getDni();
            fil[4] = m.getTelefono();
            fil[5] = m.getCorreo();
            fil[6] = m.getDireccion();
            fil[7] = m.getUsuario();
            fil[8] = m.getContrasena();
            return fil;
        }

        return null;
    }

    @Override
    public String EliminarCliente(Context context, String cod) {

        String msg=new DaoClientesImp().eliminarCliente(context,cod);
        if(msg==null){
            msg="Empleado Eliminado";
        }
        return msg;
    }

}

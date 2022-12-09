package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoAdministradorImp;
import com.example.restaurante_alfredito.dto.Administrador;

import java.util.ArrayList;

public class ServicioAdministradorImp implements  ServicioAdministrador{
    @Override
    public Object[] validarAdministrador(Context context, String usu, String pas) {
        ArrayList lis=new DaoAdministradorImp().ListarAdministrador(context);


        if (lis!=null) {
            for (int i = 0; i < lis.size(); i++) {
                Administrador p = ( Administrador) lis.get(i);

                if (p.getUsuario().equals(usu) && p.getContrasena().equals(pas)) {
                    Object[]fil=new Object[8];
                    fil[0]=p.getIdadmin();
                    fil[1]=p.getNombre();
                    fil[2]=p.getApellido();
                    fil[3]=p.getDni();
                    fil[4]=p.getTelefono();
                    fil[5]=p.getFoto();
                    fil[6]=p.getUsuario();
                    fil[7]=p.getContrasena();
                    return fil;
                }
            }
        }
        return null;
    }

    @Override
    public String RegistrarAdmin(Context context, String idAdmin, String nombre, String apellido, String dni, String telefono, byte[] imagen, String usuario, String contrasena) {

        Administrador m=new Administrador();

        m.setIdadmin(idAdmin);
        m.setNombre(nombre);
        m.setApellido(apellido);
        m.setDni(dni);
        m.setTelefono(telefono);
        m.setFoto(imagen);
        m.setUsuario(usuario);
        m.setContrasena(contrasena);


        String msg=new DaoAdministradorImp().CrearRegistroAdmin(context,m);
        if (msg==null) {
            msg="Admin Agregado";
            msg="Admin Agregado";
        }
        return msg;
    }

    @Override
    public String ActualizarAdmin(Context context, String idAdmin, String nombre, String apellido, String dni, String telefono, byte[] imagen, String usuario, String contrasena) {
        Administrador m = new Administrador();

        m.setIdadmin(idAdmin);
        m.setNombre(nombre);
        m.setApellido(apellido);
        m.setDni(dni);
        m.setTelefono(telefono);
        m.setFoto(imagen);
        m.setUsuario(usuario);
        m.setContrasena(contrasena);

        String msg = new DaoAdministradorImp().ActualizarAdmin(context, m);
        if (msg == null) {
            msg = "Admin Actualizado";
        }
        return msg;

    }

    @Override
    public Object[] Buscar_Admin(Context context, String cod) {

        Administrador m = new DaoAdministradorImp().BuscarAdmin(context, cod);
        if (m != null) {
            Object[] fil = new Object[7];
            fil[0] = m.getIdadmin();
            fil[1] = m.getNombre();
            fil[2] = m.getApellido();
            fil[3] = m.getDni();
            fil[4] = m.getTelefono();
            fil[5] = m.getFoto();
            fil[6] = m.getUsuario();
            fil[7] = m.getContrasena();
            return fil;
        }

        return null;
    }
}

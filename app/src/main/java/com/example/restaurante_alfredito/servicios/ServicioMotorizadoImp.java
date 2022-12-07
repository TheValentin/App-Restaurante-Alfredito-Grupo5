package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoMotorizado;
import com.example.restaurante_alfredito.DAO.DaoMotorizadoImp;
import com.example.restaurante_alfredito.DAO.DaoProductoImp;
import com.example.restaurante_alfredito.dto.Motorizado;
import com.example.restaurante_alfredito.dto.Producto;

import java.util.ArrayList;
import java.util.List;

public class ServicioMotorizadoImp implements  ServicioMotorizado{



    @Override
    public Object[] validarMotorizado(Context context, String usu, String pas) {
        ArrayList lis=new DaoMotorizadoImp().ListarMotorizado(context);


        if (lis!=null) {
            for (int i = 0; i < lis.size(); i++) {
                Motorizado p = (Motorizado) lis.get(i);


                if (p.getUsuario().equals(usu) && p.getContrasena().equals(pas)) {
                    Object[]fil=new Object[8];
                    fil[0]=p.getIdmotorizado();
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
    public String RegistrarEmpleado(Context context, String idEmpleado, String nombre, String apellido, String dni, String telefono, byte[] imagen, String usuario, String contrasena) {

        Motorizado m=new Motorizado();

        m.setIdmotorizado(idEmpleado);
        m.setNombre(nombre);
        m.setApellido(apellido);
        m.setDni(dni);
        m.setTelefono(telefono);
        m.setFoto(imagen);
        m.setUsuario(usuario);
        m.setContrasena(contrasena);


        String msg=new DaoMotorizadoImp().CrearRegistroEmpleado(context,m);
        if (msg==null) {
            msg="Empleado Agregado";
        }
        return msg;
    }

    @Override
    public String ActualizarEmpleado(Context context, String idEmpleado, String nombre, String apellido, String dni, String telefono, byte[] imagen, String usuario, String contrasena) {
        Motorizado m = new Motorizado();

        m.setIdmotorizado(idEmpleado);
        m.setNombre(nombre);
        m.setApellido(apellido);
        m.setDni(dni);
        m.setTelefono(telefono);
        m.setFoto(imagen);
        m.setUsuario(usuario);
        m.setContrasena(contrasena);

        String msg = new DaoMotorizadoImp().ActualizarEmpleado(context, m);
        if (msg == null) {
            msg = "Empleado Actualizado";
        }
        return msg;

    }

    @Override
    public Object[] Buscar_Motorizado(Context context, String cod) {

        Motorizado m = new DaoMotorizadoImp().BuscarMotorizado(context, cod);
        if (m != null) {
            Object[] fil = new Object[7];
            fil[0] = m.getIdmotorizado();
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

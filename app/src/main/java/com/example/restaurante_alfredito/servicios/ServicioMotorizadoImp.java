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
                    Object[]fil=new Object[2];
                    fil[0]=p.getIdmotorizado();
                    fil[1]=p.getApellido()+" "+p.getNombre();
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

}

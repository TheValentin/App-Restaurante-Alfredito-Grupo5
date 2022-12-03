package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoAdministradorImp;
import com.example.restaurante_alfredito.DAO.DaoClientesImp;
import com.example.restaurante_alfredito.dto.Administrador;
import com.example.restaurante_alfredito.dto.Clientes;

import java.util.ArrayList;

public class ServicioAdministradorImp implements  ServicioAdministrador{
    @Override
    public Object[] validarAdministrador(Context context, String usu, String pas) {
        ArrayList lis=new DaoAdministradorImp().ListarAdministrador(context);


        if (lis!=null) {
            for (int i = 0; i < lis.size(); i++) {
                Administrador p = ( Administrador) lis.get(i);

                if (p.getUsuario().equals(usu) && p.getContrasena().equals(pas)) {
                    Object[]fil=new Object[2];
                    fil[0]=p.getIdadmin();
                    fil[1]=p.getApellido()+" "+p.getNombre();
                    return fil;
                }
            }
        }
        return null;
    }
}

package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoClientesImp;
import com.example.restaurante_alfredito.DAO.DaoMotorizadoImp;
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
}

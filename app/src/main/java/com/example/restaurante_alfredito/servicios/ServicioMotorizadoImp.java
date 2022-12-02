package com.example.restaurante_alfredito.servicios;

import android.content.Context;

import com.example.restaurante_alfredito.DAO.DaoMotorizado;
import com.example.restaurante_alfredito.DAO.DaoMotorizadoImp;
import com.example.restaurante_alfredito.dto.Motorizado;

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
}

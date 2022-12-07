package com.example.restaurante_alfredito.Actividades.uiAdministrador.Persistencia_empleados;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.servicios.ServicioMotorizado;
import com.example.restaurante_alfredito.servicios.ServicioMotorizadoImp;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class persistencia_empleadosFragment extends Fragment {



    TextInputLayout idMotorizado,nombreMotorizado,apellidoMotorizado,dniMotorizado,telefonoMotorizado,usuarioMotorizado,contrasenaMotorizado;
    ImageView fotoMotorizado;

    Button GuardarMotorizado,EliminarMotorizado,BuscarEmpleado;

    ServicioMotorizado servicioMotorizado;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_persistencia_empleados,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        servicioMotorizado=new ServicioMotorizadoImp();

        idMotorizado=(TextInputLayout) view.findViewById(R.id.txtIdEmpleado_Registro_admin);
        nombreMotorizado=(TextInputLayout) view.findViewById(R.id.txtNombreEmpleado_Registro_admin);
        apellidoMotorizado=(TextInputLayout) view.findViewById(R.id.txtApellidoEmpleado_Registro_admin);
        dniMotorizado=(TextInputLayout) view.findViewById(R.id.txtDniEmpleado_Registro_admin);
        telefonoMotorizado=(TextInputLayout) view.findViewById(R.id.txtTelefonoEmpleado_Registro_admin);
        usuarioMotorizado=(TextInputLayout) view.findViewById(R.id.txtusuarioEmpleado_Registro_admin);
        contrasenaMotorizado=(TextInputLayout) view.findViewById(R.id.txtContrasenaEmpleado_Registro_admin);

        GuardarMotorizado=(Button) view.findViewById(R.id.btnGuardarEmpleado_Registro_admin);
        EliminarMotorizado=(Button) view.findViewById(R.id.btnEliminarEmpleado_Registro_admin);
        BuscarEmpleado=(Button) view.findViewById(R.id.btnBuscarEmpleado_Registro_admin);

        //Agregar empleado//
        GuardarMotorizado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!(idMotorizado.getEditText().getText().toString().equals("")|| nombreMotorizado.getEditText().getText().toString().equals("") || apellidoMotorizado.getEditText().getText().toString().equals("") || dniMotorizado.getEditText().getText().toString().equals("")|| telefonoMotorizado.getEditText().getText().toString().equals("") || usuarioMotorizado.getEditText().getText().toString().equals("")|| contrasenaMotorizado.getEditText().getText().toString().equals(""))){

                    servicioMotorizado.RegistrarEmpleado(getActivity(),idMotorizado.getEditText().getText().toString(),nombreMotorizado.getEditText().getText().toString(),apellidoMotorizado.getEditText().getText().toString(),dniMotorizado.getEditText().getText().toString(),telefonoMotorizado.getEditText().getText().toString(),null,usuarioMotorizado.getEditText().getText().toString(), contrasenaMotorizado.getEditText().getText().toString() );

                    new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE)
                            .setTitleText("Registro guardado")
                            .show();

                    limpiarCaja(false);
                }else {
                    new SweetAlertDialog(getActivity(),SweetAlertDialog.ERROR_TYPE)
                            .setTitleText("Completa todos los campos")
                            .show();
                }

            }
        });

        BuscarEmpleado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });





    }

    private void limpiarCaja(boolean limpiarCodigo){
        if(limpiarCodigo){

        }else {

            idMotorizado.getEditText().setText("");
            nombreMotorizado.getEditText().setText("");
            apellidoMotorizado.getEditText().setText("");
            dniMotorizado.getEditText().setText("");
            telefonoMotorizado.getEditText().setText("");
            usuarioMotorizado.getEditText().setText("");
            contrasenaMotorizado.getEditText().setText("");

        }
    }

}
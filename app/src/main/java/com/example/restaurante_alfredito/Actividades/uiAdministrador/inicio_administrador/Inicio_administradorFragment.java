package com.example.restaurante_alfredito.Actividades.uiAdministrador.inicio_administrador;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.servicios.ServicioAdministrador;
import com.example.restaurante_alfredito.servicios.ServicioAdministradorImp;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class Inicio_administradorFragment extends Fragment {

    private TextInputLayout txtIDadmin ,txtnombre,txtapellido,txtdni,txttelefono,txtusuario,txtcontrasena;
    private Button btnActualizar;
    ServicioAdministrador servicioAdministrador;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_inicio_administrador,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        servicioAdministrador=new ServicioAdministradorImp();

        txtIDadmin=(TextInputLayout) view.findViewById(R.id.txtIdAdmin_inicioAdmin);
        txtnombre=(TextInputLayout) view.findViewById(R.id.txtNombre_inicioAdmin);
        txtapellido=(TextInputLayout) view.findViewById(R.id.txtNombre_inicioAdmin);
        txtdni=(TextInputLayout) view.findViewById(R.id.txtDNI_inicioAdmin);
        txttelefono=(TextInputLayout) view.findViewById(R.id.txtTelefono_inicioAdmin);
        txtusuario=(TextInputLayout) view.findViewById(R.id.txtUsuario_inicioAdmin);
        txtcontrasena=(TextInputLayout) view.findViewById(R.id.txtContrasena_inicioAdmin);

        btnActualizar=(Button) view.findViewById(R.id.btnActualizar_inicioAdmin);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                servicioAdministrador.ActualizarAdmin(getActivity(),txtIDadmin.getEditText().getText().toString(), txtnombre.getEditText().getText().toString(),txtapellido.getEditText().getText().toString(),txtdni.getEditText().getText().toString(),txttelefono.getEditText().getText().toString(),null,txtusuario.getEditText().getText().toString(),txtcontrasena.getEditText().getText().toString());


                new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Registro Actualizado")
                        .show();



            }
        });




    }
}
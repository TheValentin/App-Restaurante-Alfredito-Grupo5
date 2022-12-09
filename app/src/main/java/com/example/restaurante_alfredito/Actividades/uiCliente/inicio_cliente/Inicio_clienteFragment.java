package com.example.restaurante_alfredito.Actividades.uiCliente.inicio_cliente;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.servicios.ServicioAdministrador;
import com.example.restaurante_alfredito.servicios.ServicioAdministradorImp;
import com.example.restaurante_alfredito.servicios.ServicioClientes;
import com.example.restaurante_alfredito.servicios.ServicioClientesImp;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;
import android.graphics.Color;
import android.widget.Button;

public class Inicio_clienteFragment extends Fragment {

    private TextInputLayout txtIDcliente ,txtnombre,txtapellido,txtdni,txttelefono,txtcorreo,txtdireccion,txtusuario,txtcontrasena;
    private Button btnActualizar;
    ServicioClientes servicioClientes;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_inicio_cliente,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        servicioClientes=new ServicioClientesImp();

        txtIDcliente=(TextInputLayout) view.findViewById(R.id.txtIdCliente_inicioCliente);
        txtnombre=(TextInputLayout) view.findViewById(R.id.txtNombre_inicioCliente);
        txtapellido=(TextInputLayout) view.findViewById(R.id.txtApellido_inicioCliente);
        txtdni=(TextInputLayout) view.findViewById(R.id.txtDNI_inicioCliente);
        txttelefono=(TextInputLayout) view.findViewById(R.id.txtTelefono_inicioCliente);
        txtcorreo=(TextInputLayout) view.findViewById(R.id.txtCorreo_inicioCliente);
        txtdireccion=(TextInputLayout) view.findViewById(R.id.txtDireccion_inicioCliente);
        txtusuario=(TextInputLayout) view.findViewById(R.id.txtUsuario_inicioCliente);
        txtcontrasena=(TextInputLayout) view.findViewById(R.id.txtContrasena_inicioCliente);

        btnActualizar=(Button) view.findViewById(R.id.btnActualizar_inicioCliente);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                servicioClientes.ActualizarClientes(getActivity(),txtIDcliente.getEditText().getText().toString(), txtnombre.getEditText().getText().toString(),txtapellido.getEditText().getText().toString(),txtdni.getEditText().getText().toString(),txttelefono.getEditText().getText().toString(),txtcorreo.getEditText().getText().toString(),txtdireccion.getEditText().getText().toString(),txtusuario.getEditText().getText().toString(),txtcontrasena.getEditText().getText().toString());


                new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Registro Actualizado")
                        .show();



            }
        });

    }

}
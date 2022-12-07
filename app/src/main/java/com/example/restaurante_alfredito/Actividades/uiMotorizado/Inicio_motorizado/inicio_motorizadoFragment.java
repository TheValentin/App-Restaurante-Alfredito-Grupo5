package com.example.restaurante_alfredito.Actividades.uiMotorizado.Inicio_motorizado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.servicios.ServicioMotorizado;
import com.example.restaurante_alfredito.servicios.ServicioMotorizadoImp;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class inicio_motorizadoFragment extends Fragment {

    private TextInputLayout txtIDmotrizado ,txtnombre,txtapellido,txtdni,txttelefono,txtusuario,txtcontrasena;
    private Button btnActualizar;
    ServicioMotorizado servicioMotorizado;

    ListView listahistorial;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_inicio_motorizado,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        servicioMotorizado=new ServicioMotorizadoImp();

        txtIDmotrizado=(TextInputLayout) view.findViewById(R.id.txtIdMotorizado_inicioEmpleado);
        txtnombre=(TextInputLayout) view.findViewById(R.id.txtnombre_inicioEmpleado);
        txtapellido=(TextInputLayout) view.findViewById(R.id.txtApellido_inicioEmpleado);
        txtdni=(TextInputLayout) view.findViewById(R.id.txtDni_inicioEmpleado);
        txttelefono=(TextInputLayout) view.findViewById(R.id.txtTelefono_inicioEmpleado);
        txtusuario=(TextInputLayout) view.findViewById(R.id.txtusuario_inicioEmpleado);
        txtcontrasena=(TextInputLayout) view.findViewById(R.id.txtContrasena_inicioEmpleado);

        btnActualizar=(Button) view.findViewById(R.id.btnActualizar_inicioEmpleado);

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                servicioMotorizado.ActualizarEmpleado(getActivity(),txtIDmotrizado.getEditText().getText().toString(), txtnombre.getEditText().getText().toString(),txtapellido.getEditText().getText().toString(),txtdni.getEditText().getText().toString(),txttelefono.getEditText().getText().toString(),null,txtusuario.getEditText().getText().toString(),txtcontrasena.getEditText().getText().toString());


                new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Registro Actualizado")
                        .show();



            }
        });




    }
}
package com.example.restaurante_alfredito.Actividades.uiCliente.inicio_cliente;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.Actividades.ClienteMenuActivity;
import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.antivity_iniciar1;
import com.example.restaurante_alfredito.servicios.ServicioClientes;
import com.example.restaurante_alfredito.servicios.ServicioClientesImp;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;

import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;

public class Inicio_clienteFragment extends Fragment {

    private TextInputLayout txtIDcliente ,txtnombre,txtapellido,txtdni,txttelefono,txtcorreo,txtdireccion,txtusuario,txtcontrasena;
    private Button btnActualizar, btnEliinarcuenta;
    ServicioClientes servicioClientes;

    ListView listahistorial;
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
        btnEliinarcuenta=(Button) view.findViewById(R.id.btnEliminarCuentaCliente);

        String idCliente= ClienteMenuActivity.IDCliente;

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                servicioClientes.ActualizarClientes(getActivity(),txtIDcliente.getEditText().getText().toString(), txtnombre.getEditText().getText().toString(),txtapellido.getEditText().getText().toString(),txtdni.getEditText().getText().toString(),txttelefono.getEditText().getText().toString(),txtcorreo.getEditText().getText().toString(),txtdireccion.getEditText().getText().toString(),txtusuario.getEditText().getText().toString(),txtcontrasena.getEditText().getText().toString());


                new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Registro Actualizado")
                        .show();

            }
        });
        btnEliinarcuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDialogo();

            }
        });

        Object[] ListaCliente =servicioClientes.Buscar_Clientes(getActivity(),idCliente);

        txtIDcliente.getEditText().setText(ListaCliente[0].toString());
        txtnombre.getEditText().setText(""+ListaCliente[1].toString());
        txtapellido.getEditText().setText(""+ListaCliente[2].toString());
        txtdni.getEditText().setText(""+ListaCliente[3].toString());
        txttelefono.getEditText().setText(""+ListaCliente[4].toString());
        txtcorreo.getEditText().setText(""+ListaCliente[5].toString());
        txtdireccion.getEditText().setText(""+ListaCliente[6].toString());

        txtusuario.getEditText().setText(""+ListaCliente[7]);
        txtcontrasena.getEditText().setText(""+ListaCliente[8]);


    }
    private void mostrarDialogo(){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        builder.setTitle("Eliminar Cuenta");
        builder.setMessage("Quieres Eliminar tu cuenta, se borrar todo tus datos")
                .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        servicioClientes.EliminarCliente(getActivity(),txtIDcliente.getEditText().getText().toString());
                        Toast.makeText(getActivity().getApplicationContext(), "Eliminando...",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getActivity(), antivity_iniciar1.class);
                        startActivity(intent);
                    }
                })
                .setNegativeButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getActivity().getApplicationContext(), "Cancelado",Toast.LENGTH_SHORT).show();

                    }
                }).show();

    }

}
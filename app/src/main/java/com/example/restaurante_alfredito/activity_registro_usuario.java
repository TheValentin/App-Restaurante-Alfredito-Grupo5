package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.restaurante_alfredito.Actividades.AdministradorMenuActivity;
import com.example.restaurante_alfredito.dto.Clientes;
import com.example.restaurante_alfredito.servicios.ServicioClientes;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class activity_registro_usuario extends AppCompatActivity {

    private TextInputLayout txtnombre,txtapellido,txttelefono, txtdni,txtcorreo,txtusuario,txtcontrasena,txtdireccion,txtidUsuario;


    ServicioClientes servicioClientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
        enlazarcontroladores();
    }

    private void enlazarcontroladores(){
        txtnombre=(TextInputLayout) findViewById(R.id.txtnombre);
        txtapellido=(TextInputLayout) findViewById(R.id.txtapellido);
        txttelefono=(TextInputLayout) findViewById(R.id.txttelefono);
        txtdni=(TextInputLayout) findViewById(R.id.txtdni);
        txtcorreo=(TextInputLayout) findViewById(R.id.txtcorreo);
        txtusuario=(TextInputLayout) findViewById(R.id.txtUsuarioRegistro);
        txtcontrasena=(TextInputLayout) findViewById(R.id.txtcontraseña);
        txtdireccion=(TextInputLayout) findViewById(R.id.txtdireccion);
        txtidUsuario=(TextInputLayout) findViewById(R.id.txtidUsuarioRegistrar);

    }

    public void Registrar_cliente(View v){

        if(!(txtnombre.getEditText().getText().toString().equals("") || txtapellido.getEditText().getText().toString().equals("") || txttelefono.getEditText().getText().toString().equals("") || txtdni.getEditText().getText().toString().equals("") || txtcorreo.getEditText().getText().toString().equals("") || txtusuario.getEditText().getText().toString().equals("") || txtcontrasena.getEditText().getText().toString().equals("") || txtdireccion.getEditText().getText().toString().equals("") || txtidUsuario.getEditText().getText().toString().equals(""))){

            //servicioClientes.RegistrarUsuariosCLientes(this,txtnombre.getEditText().getText().toString(),txtapellido.getEditText().getText().toString(),txttelefono.getEditText().getText().toString(),txtdni.getEditText().getText().toString(),txtcorreo.getEditText().getText().toString(),txtusuario.getEditText().getText().toString(),txtcontrasena.getEditText().getText().toString(),txtdireccion.getEditText().getText().toString(),txtidUsuario.getEditText().getText().toString() );


            new SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Registro guardado")
                    .show();
            Intent intent = new Intent(this, antivity_iniciar1.class);
            startActivity(intent);




        }else {
            new SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Completa todos los campos")
                    .show();


        }

    }



}
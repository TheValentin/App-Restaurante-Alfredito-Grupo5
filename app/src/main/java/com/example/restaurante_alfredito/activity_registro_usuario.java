package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.restaurante_alfredito.DAO_Utilidad.cliente;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;
import com.google.android.material.textfield.TextInputLayout;


public class activity_registro_usuario extends AppCompatActivity {

    private TextInputLayout txtnombre,txtapellido,txttelefono, txtdni,txtcorreo,txtusuario,txtcontrasena,txtdireccion;




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

    }

    public void Registrar_usuario(View v){


        String nombre=txtnombre.getEditText().getText().toString();
        String apellido=txtapellido.getEditText().getText().toString();
        String telefono=txttelefono.getEditText().getText().toString();
        String dni=txtdni.getEditText().getText().toString();
        String correo=txtcorreo.getEditText().getText().toString();
        String usuario=txtusuario.getEditText().getText().toString();
        String contrasena=txtcontrasena.getEditText().getText().toString();
        String diireccion=txtdireccion.getEditText().getText().toString();



        cliente cliente=new cliente(activity_registro_usuario.this, GlobalesApp.BDD,null,GlobalesApp.VERSION);
        long id= cliente.Registrar_cuenta(nombre,apellido,dni,telefono,correo,diireccion,usuario,contrasena);
        if (id>0){
            Toast.makeText(this, "Registrado con Exito", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, antivity_iniciar1.class);
            startActivity(intent);
        }else{
            Toast.makeText(this, "Registrado con Error", Toast.LENGTH_SHORT).show();
        }



    }
}
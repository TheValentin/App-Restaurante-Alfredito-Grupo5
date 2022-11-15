package com.example.restaurante_alfredito;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurante_alfredito.Actividades.AdministradorMenuActivity;
import com.example.restaurante_alfredito.Actividades.ClienteMenuActivity;
import com.example.restaurante_alfredito.Actividades.MotorizadoMenuActivity;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class antivity_iniciar1 extends AppCompatActivity {



    private TextInputLayout txtUsuario, txtContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antivity_iniciar1);
        enlazarControlado();
    }
    private void enlazarControlado() {
        txtUsuario = (TextInputLayout) findViewById(R.id.txtUsuario);
        txtContraseña = (TextInputLayout) findViewById(R.id.txtContrasena);
    }

    public void LoginIniciando(View v){

        String usuAdm="admin";
        String usuMoto="moto";
        String usuClien="cliente";
        String Contraseña="123";

        if( txtUsuario.getEditText().getText().toString().equals(usuAdm) && txtContraseña.getEditText().getText().toString().equals(Contraseña) ){



            new SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Bienvenido Administrador")
                    .show();

            Intent intent = new Intent(this, AdministradorMenuActivity.class);
            startActivity(intent);

        }
        else  if( txtUsuario.getEditText().getText().toString().equals(usuMoto) && txtContraseña.getEditText().getText().toString().equals(Contraseña) ){


            new SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Bienvenido Motorizado")
                    .show();

            Intent intent = new Intent(this, MotorizadoMenuActivity.class);
            startActivity(intent);

        }
        else  if( txtUsuario.getEditText().getText().toString().equals(usuClien) && txtContraseña.getEditText().getText().toString().equals(Contraseña) ){


            new SweetAlertDialog(this,SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("Bienvenido Cliente")
                    .show();
            Intent intent = new Intent(this, ClienteMenuActivity.class);
            startActivity(intent);
        }
        else  if( txtUsuario.getEditText().getText().toString().equals("") || txtContraseña.getEditText().getText().toString().equals("") ){


            new SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Complete el campo usuario o contraseña")
                    .show();
        } else {

            new SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Credenciales incorrectos")
                    .show();
        }


    }
}
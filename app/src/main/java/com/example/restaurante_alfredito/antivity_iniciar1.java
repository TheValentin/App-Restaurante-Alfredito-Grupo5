package com.example.restaurante_alfredito;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurante_alfredito.Actividades.AdministradorMenuActivity;
import com.example.restaurante_alfredito.Actividades.ClienteMenuActivity;
import com.example.restaurante_alfredito.Actividades.MotorizadoMenuActivity;
import com.example.restaurante_alfredito.DAO.DaoClientesImp;
import com.example.restaurante_alfredito.dto.Clientes;
import com.example.restaurante_alfredito.servicios.ServicioAdministrador;
import com.example.restaurante_alfredito.servicios.ServicioAdministradorImp;
import com.example.restaurante_alfredito.servicios.ServicioClientes;
import com.example.restaurante_alfredito.servicios.ServicioClientesImp;
import com.example.restaurante_alfredito.servicios.ServicioMotorizado;
import com.example.restaurante_alfredito.servicios.ServicioMotorizadoImp;
import com.google.android.material.textfield.TextInputLayout;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class antivity_iniciar1 extends AppCompatActivity {


    ServicioMotorizado serv_m ;
    ServicioAdministrador serv_a;
    ServicioClientes serv_c;

    private TextInputLayout txtUsuario, txtContraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antivity_iniciar1);


        enlazarControlado();
        serv_m = new ServicioMotorizadoImp();
        serv_a= new ServicioAdministradorImp();
        serv_c=new ServicioClientesImp();


    }
    private void enlazarControlado() {
        txtUsuario = (TextInputLayout) findViewById(R.id.txtUsuario);
        txtContraseña = (TextInputLayout) findViewById(R.id.txtContrasena);
    }

    public void LoginIniciando(View v){


        Object[] fil_M = serv_m .validarMotorizado(antivity_iniciar1.this,txtUsuario.getEditText().getText().toString(),txtContraseña.getEditText().getText().toString());
        Object[] fil_A= serv_a .validarAdministrador(antivity_iniciar1.this,txtUsuario.getEditText().getText().toString(),txtContraseña.getEditText().getText().toString());
        Object[] fil_C= serv_c .validarClientes(antivity_iniciar1.this,txtUsuario.getEditText().getText().toString(),txtContraseña.getEditText().getText().toString());

        if(fil_M!= null || fil_A!= null || fil_C!= null){

               if (fil_M!=null){

                   Intent intent = new Intent(this, MotorizadoMenuActivity.class);
                   Bundle bundle = new Bundle();
                   bundle.putString("IDMotorrizado",""+fil_M[0]);
                   intent.putExtras(bundle);
                   startActivity(intent);
                         }
               if (fil_A!=null){
                   Intent intent = new Intent(this, AdministradorMenuActivity.class);
                   //Bundle bundle = new Bundle();
                   //bundle.putString("IDAdministrador",""+fil_A[0]);
                   //intent.putExtras(bundle);
                   startActivity(intent);
               }
               if (fil_C!=null){
                   Intent intent = new Intent(this, ClienteMenuActivity.class);
                   Bundle bundle = new Bundle();
                   //bundle.putString("IDCliente",""+fil_C[0]);
                   //intent.putExtras(bundle);
                   startActivity(intent);
               }

        }else {

            new SweetAlertDialog(this,SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("Credenciales incorrectos")
                    .show();
        }




/*

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

*/

    }
}
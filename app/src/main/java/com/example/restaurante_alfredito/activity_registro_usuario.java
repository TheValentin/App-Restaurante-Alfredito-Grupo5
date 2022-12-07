package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;

import com.example.restaurante_alfredito.servicios.ServicioClientes;
import com.example.restaurante_alfredito.servicios.ServicioClientesImp;
import com.google.android.material.textfield.TextInputLayout;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

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
        txtcontrasena=(TextInputLayout) findViewById(R.id.txtcontraseñaRegistroUsuario);
        txtdireccion=(TextInputLayout) findViewById(R.id.txtdireccion);
        txtidUsuario=(TextInputLayout) findViewById(R.id.txtidUsuarioRegistrar);
        servicioClientes=new ServicioClientesImp();

    }
/*

   ///////// dice que esta incompleto pero no se ...
    private String desencriptar(String datos, String password) throws Exception{
        SecretKeySpec secretKey = generateKey(password);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] datosDescoficados = Base64.decode(datos, Base64.DEFAULT);
        byte[] datosDesencriptadosByte = cipher.doFinal(datosDescoficados);
        String datosDesencriptadosString = new String(datosDesencriptadosByte);
        return datosDesencriptadosString;
    }

    private String encriptar(String passwordUsuario, String usuario) throws Exception{
        SecretKeySpec secretKey = generateKey(usuario);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] datosEncriptadosBytes = cipher.doFinal(passwordUsuario.getBytes());
        String datosEncriptadosString = Base64.encodeToString(datosEncriptadosBytes, Base64.DEFAULT);
        return datosEncriptadosString;
    }

    private SecretKeySpec generateKey(String usuario) throws Exception{
        MessageDigest sha = MessageDigest.getInstance("SHA-256");
        byte[] key = usuario.getBytes("UTF-8");
        key = sha.digest(key);
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");
        return secretKey;
    }


*/

    public void Registrar_cliente(View v) {

        String password=txtcontrasena.getEditText().getText().toString();
        String usuario=txtusuario.getEditText().getText().toString();


        if(!(txtnombre.getEditText().getText().toString().equals("") || txtapellido.getEditText().getText().toString().equals("") || txttelefono.getEditText().getText().toString().equals("") || txtdni.getEditText().getText().toString().equals("") || txtcorreo.getEditText().getText().toString().equals("") || txtusuario.getEditText().getText().toString().equals("") || txtcontrasena.getEditText().getText().toString().equals("") || txtdireccion.getEditText().getText().toString().equals("") || txtidUsuario.getEditText().getText().toString().equals(""))){

           // String Contraseñaincriptada=encriptar(password,usuario);

        String a=servicioClientes.RegistrarUsuariosCLientes(activity_registro_usuario.this,txtnombre.getEditText().getText().toString(),txtapellido.getEditText().getText().toString(),txttelefono.getEditText().getText().toString(),txtdni.getEditText().getText().toString(),txtcorreo.getEditText().getText().toString(),txtusuario.getEditText().getText().toString(),txtcontrasena.getEditText().getText().toString(),txtdireccion.getEditText().getText().toString(),txtidUsuario.getEditText().getText().toString() );

        Log.i("infoxxx",""+a);
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


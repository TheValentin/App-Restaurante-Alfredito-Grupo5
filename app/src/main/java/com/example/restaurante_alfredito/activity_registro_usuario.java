package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.restaurante_alfredito.Actividades.AdministradorMenuActivity;

public class activity_registro_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_usuario);
    }

    public void proceso(View v){
        Toast.makeText(this, "Registrado con Exito", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, antivity_iniciar1.class);
        startActivity(intent);
    }
}
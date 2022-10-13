package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    public void procesoIniciar(View v){
            Intent intent = new Intent(this, antivity_iniciar1.class);
            startActivity(intent);


    }
    public void procesoRegistro(View v){
        Intent intent = new Intent(this, activity_registro_usuario.class);
        startActivity(intent);
    }
}
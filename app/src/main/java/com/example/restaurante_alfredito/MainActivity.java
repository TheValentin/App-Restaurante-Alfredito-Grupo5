package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void procesar(View v){
        Intent intent = new Intent(this, antivity_iniciar1.class);
        startActivity(intent);

    }
}
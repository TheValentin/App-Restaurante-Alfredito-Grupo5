package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class PasarelaPagos extends AppCompatActivity {
    private RadioButton rBtnEfectivo, rBtnBilletera, rBtnTarjeta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasarela_pagos);
        enlazarControles();
    }

    private void enlazarControles(){
        rBtnEfectivo=(RadioButton) findViewById(R.id.rBtnEfectivo);
        rBtnBilletera=(RadioButton) findViewById(R.id.rBtnBilletera);
        rBtnTarjeta=(RadioButton) findViewById(R.id.rBtnTarjeta);
    }

    public void seleccionar (View v){
        if(rBtnEfectivo.isChecked()){
            Intent intent1 =new Intent(this,PPEfectivo.class);
            startActivity(intent1);
        }else if(rBtnBilletera.isChecked()){
            Intent intent2 =new Intent(this,PPBilletera.class);
            startActivity(intent2);
        }else if(rBtnTarjeta.isChecked()){
            Intent intent3 =new Intent(this,PPTarjeta.class);
            startActivity(intent3);
        }

    }
}
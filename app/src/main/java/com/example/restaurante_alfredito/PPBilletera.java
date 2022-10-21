package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PPBilletera extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ppbilletera);
    }
    public void procesoMap(View v){
        Intent intent = new Intent(this, actiivty_Google_Map.class);
        startActivity(intent);
    }


}
package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.restaurante_alfredito.SERVICIOS.ConectarDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

public class MainActivity extends AppCompatActivity {


    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db =new ConectarDB(this , GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();
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
package com.example.restaurante_alfredito;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Carrito extends AppCompatActivity {
    Button decrease, increase;
    TextView displayInteger;
    int minteger = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_carrito);
        enlazarAcciones();
    }

    private void enlazarAcciones(){
        decrease=(Button) findViewById(R.id.decrease);
        increase=(Button) findViewById(R.id.increase);
        displayInteger = (TextView) findViewById(
                R.id.integer_number);
        decrease.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(Carrito.this, "Clicked on Button -", Toast.LENGTH_LONG).show();
                minteger = minteger - 1;
                Log.i("minteger", String.valueOf(minteger));
                displayInteger.setText("" + minteger);
            }
        });
        increase.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Toast.makeText(Carrito.this, "Clicked on Button +", Toast.LENGTH_LONG).show();
                minteger = minteger + 1;
                Log.i("minteger", String.valueOf(minteger));
                displayInteger.setText("" + minteger);
            }
        });
        Log.i("displayInteger", displayInteger.getText().toString());
    }
}
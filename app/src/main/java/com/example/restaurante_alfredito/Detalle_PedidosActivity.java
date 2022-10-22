package com.example.restaurante_alfredito;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class Detalle_PedidosActivity extends AppCompatActivity {

    ListView listView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_pedidos);


        listView5=(ListView)findViewById(R.id.lista_de_pedidos_detalle);

        ArrayList<Productos> arrayList3 = new ArrayList<>();
        arrayList3.add(new Productos(R.drawable.arroz_chaufa,"arroz_chaufa","S/.15","1"));
        arrayList3.add(new Productos(R.drawable.arroz_con_pollo,"arroz_con_pollo","S/.10","1"));
        arrayList3.add(new Productos(R.drawable.causa,"causa","S/.12","2"));
        arrayList3.add(new Productos(R.drawable.ceviche,"ceviche","S./13","1"));

        AdaptaerDetalle_Pedidos pppp6 = new  AdaptaerDetalle_Pedidos (this, R.layout.fila_detalle,arrayList3);



        listView5.setAdapter(pppp6);

    }
}
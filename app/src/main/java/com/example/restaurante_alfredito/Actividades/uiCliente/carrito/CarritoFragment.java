package com.example.restaurante_alfredito.Actividades.uiCliente.carrito;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restaurante_alfredito.Actividades.AdministradorMenuActivity;
import com.example.restaurante_alfredito.Actividades.ClienteMenuActivity;
import com.example.restaurante_alfredito.Actividades.uiCliente.lista_de_comidas.Lista_de_comidasFragment;
import com.example.restaurante_alfredito.AdapterCarrito;
import com.example.restaurante_alfredito.AdapterCatalago;
import com.example.restaurante_alfredito.PasarelaPagos;
import com.example.restaurante_alfredito.Productos;
import com.example.restaurante_alfredito.R;

import java.util.ArrayList;


public class CarritoFragment extends Fragment {

    public Button BtnPasarela;
    public static ListView listView2;




public static  AdapterCarrito pppp2;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_carrito,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ClienteMenuActivity.arrayList_cesta_2.clear();

        listView2= (ListView)view.findViewById(R.id.listapedidoscarrito);

        for (int i = 0; i < ClienteMenuActivity.arrayList2_CESTA.size(); i++) {
            Object[] a= (Object[]) ClienteMenuActivity.arrayList2_CESTA.get(i);


            ClienteMenuActivity.arrayList_cesta_2 .add(new Productos( (byte[])a[2], a[0].toString() ,a[1].toString(),a[3].toString(),a[4].toString()));
        }


/*
        arrayList2.add(new Productos(R.drawable.arroz_chaufa,"arroz_chaufa","15"));
        arrayList2.add(new Productos(R.drawable.arroz_con_pollo,"arroz_con_pollo","15"));
        arrayList2.add(new Productos(R.drawable.causa,"causa","15"));
        arrayList2.add(new Productos(R.drawable.ceviche,"ceviche","15"));
*/
        pppp2 = new AdapterCarrito(getActivity(), R.layout.item_carrito, ClienteMenuActivity.arrayList_cesta_2 );

        listView2.setAdapter(pppp2);

        BtnPasarela=(Button) view.findViewById(R.id.BtnPasarela);
        BtnPasarela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity().getApplicationContext(),PasarelaPagos.class);
                startActivity(intent);
            }
        });

    }
}
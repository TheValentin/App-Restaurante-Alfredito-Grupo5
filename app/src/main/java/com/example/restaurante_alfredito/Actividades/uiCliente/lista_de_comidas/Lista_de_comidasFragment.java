package com.example.restaurante_alfredito.Actividades.uiCliente.lista_de_comidas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.AdapterCatalago;
import com.example.restaurante_alfredito.Productos;
import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.servicios.ServicioProducto;
import com.example.restaurante_alfredito.servicios.ServicioProductoImp;

import java.util.ArrayList;

public class Lista_de_comidasFragment extends Fragment {

    public  static ArrayList<Productos> arrayList33 = new ArrayList<>();

    ListView listView2;
    ServicioProducto servicioProducto5;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_lista_de_comidas,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList33.clear();

        listView2= (ListView)view.findViewById(R.id.listarplatillos2);
        servicioProducto5= new ServicioProductoImp();

        for (int i = 0; i < servicioProducto5.listarProducto(getContext()).size(); i++) {
         Object[] a= (Object[]) servicioProducto5.listarProducto(getContext()).get(i);
            String [] opciones55 = {"1","2"};

            arrayList33.add(new Productos((byte[]) a[5],a[1].toString(),a[4].toString(),a[3].toString(),opciones55));
        }
/*
        arrayList2.add(new Productos(R.drawable.arroz_chaufa,"arroz_chaufa","15"));
        arrayList2.add(new Productos(R.drawable.arroz_con_pollo,"arroz_con_pollo","15"));
        arrayList2.add(new Productos(R.drawable.causa,"causa","15"));
        */
        AdapterCatalago pppp2 = new AdapterCatalago (getActivity(), R.layout.filas2,arrayList33);

        listView2.setAdapter(pppp2);
    }
}
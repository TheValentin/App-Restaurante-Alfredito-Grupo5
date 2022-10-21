package com.example.restaurante_alfredito.Actividades.uiMotorizado.Lista_de_pedidos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.AdapterPedidos;
import com.example.restaurante_alfredito.Pedidos;
import com.example.restaurante_alfredito.R;

import java.util.ArrayList;

public class lista_de_pedidosFragment extends Fragment {


    ListView listapedidos;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_de_pedidos,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listapedidos = (ListView)view.findViewById(R.id.listapedidos);

        ArrayList<Pedidos> arrayList3 = new ArrayList<>();

        arrayList3.add(new Pedidos("19-enero-2022", "Codigo: "+"126316","Pendiente","Cliente: "+"XXXXXXXXXXXXXXXX"));
        arrayList3.add(new Pedidos("19-enero-2022", "Codigo: "+"126316","Pendiente","Cliente: "+"XXXXXXXXXXXXXXXX"));
        arrayList3.add(new Pedidos("19-enero-2022", "Codigo: "+"126316","Pendiente","Cliente: "+"XXXXXXXXXXXXXXXX"));
        arrayList3.add(new Pedidos("19-enero-2022", "Codigo: "+"126316","Pendiente","Cliente: "+"XXXXXXXXXXXXXXXX"));

        AdapterPedidos pppp3 = new AdapterPedidos (getActivity(), R.layout.filas3,arrayList3);

        listapedidos.setAdapter(pppp3);
    }
}
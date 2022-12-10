package com.example.restaurante_alfredito.Actividades.uiMotorizado.Historial_de_pedidos;

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


public class historial_de_pedidos extends Fragment {


    ListView listahistorial;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_historial_de_pedidos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listahistorial = (ListView) view.findViewById(R.id.listahistorial);

        ArrayList<Pedidos> arrayList4 = new ArrayList<>();

        arrayList4.add(new Pedidos("19-enero-2022", "Codigo: " + "126316", "Completado", "Cliente: " + "XXXXXXXXXXXXXXXX","200"));
        arrayList4.add(new Pedidos("19-enero-2022", "Codigo: " + "126316", "Completado", "Cliente: " + "XXXXXXXXXXXXXXXX","200"));
        arrayList4.add(new Pedidos("19-enero-2022", "Codigo: " + "126316", "Completado", "Cliente: " + "XXXXXXXXXXXXXXXX","200"));
        arrayList4.add(new Pedidos("19-enero-2022", "Codigo: " + "126316", "Cancelado", "Cliente: " + "XXXXXXXXXXXXXXXX","200"));

        AdapterPedidos pppp4 = new AdapterPedidos(getActivity(), R.layout.filas4, arrayList4);

        listahistorial.setAdapter(pppp4);

    }
}
package com.example.restaurante_alfredito.Actividades.uiCliente.carrito;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restaurante_alfredito.AdapterPedidosCliente;
import com.example.restaurante_alfredito.PedidosCliente;
import com.example.restaurante_alfredito.R;

import java.util.ArrayList;


public class HistorialPedidoFragment extends Fragment {
    ListView listView2;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_historial_de_pedidos_cliente,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listView2= (ListView)view.findViewById(R.id.listahistorialcliente);

        ArrayList<PedidosCliente> arrayList2 = new ArrayList<>();

        arrayList2.add(new PedidosCliente("19-enero-2022", "126316", "Completado"));
        arrayList2.add(new PedidosCliente("25-enero-2022", "126316", "Completado"));
        arrayList2.add(new PedidosCliente("30-enero-2022", "126316", "Completado"));
        arrayList2.add(new PedidosCliente("31-enero-2022", "126316", "Completado"));

        AdapterPedidosCliente pppp2 = new AdapterPedidosCliente(getActivity(), R.layout.item_pedido_cliente,arrayList2);

        listView2.setAdapter(pppp2);

    }
}
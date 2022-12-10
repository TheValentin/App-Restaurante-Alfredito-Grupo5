package com.example.restaurante_alfredito.Actividades.uiCliente.carrito;

import android.os.Bundle;
import android.util.Log;
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
import com.example.restaurante_alfredito.servicios.ServicioPedido;
import com.example.restaurante_alfredito.servicios.ServicioPedidoImp;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


public class HistorialPedidoFragment extends Fragment {
    ListView listView2;
    ServicioPedido servicioPedido;
    public  static ArrayList<PedidosCliente> arrayList33 = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_historial_de_pedidos_cliente,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayList33.clear();

        listView2= (ListView)view.findViewById(R.id.listahistorialcliente);
        servicioPedido= new ServicioPedidoImp();

        for (int i = 0; i < servicioPedido.listarPedido(getContext()).size(); i++) {
            Object[] a= (Object[]) servicioPedido.listarPedido(getContext()).get(i);
            // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Log.i("fecha", a[1].toString());
            arrayList33.add(new PedidosCliente(a[1].toString(), a[0].toString(),a[2].toString()));
        }

        AdapterPedidosCliente pppp2 = new AdapterPedidosCliente(getActivity(), R.layout.item_pedido_cliente,arrayList33);

        listView2.setAdapter(pppp2);

    }
}
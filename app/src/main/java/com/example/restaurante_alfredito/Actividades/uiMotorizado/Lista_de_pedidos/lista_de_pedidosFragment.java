package com.example.restaurante_alfredito.Actividades.uiMotorizado.Lista_de_pedidos;

import android.os.Bundle;
import android.os.Vibrator;
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
import com.example.restaurante_alfredito.servicios.ServicioPedido;
import com.example.restaurante_alfredito.servicios.ServicioPedidoImp;

import java.util.ArrayList;

public class lista_de_pedidosFragment extends Fragment {

    ArrayList<Pedidos> arrayListP = new ArrayList<>();
    ListView listapedidos;
    ServicioPedido servicioPedido;
    private Vibrator vibrator;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lista_de_pedidos,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        arrayListP.clear();
        /*vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);*/
        listapedidos = (ListView)view.findViewById(R.id.listapedidos);
        servicioPedido = new ServicioPedidoImp();
        for(int i=0; i< servicioPedido.listarPedido(getContext()).size(); i++){
            Object[] p = (Object[]) servicioPedido.listarPedido(getContext()).get(i);


            arrayListP.add(new Pedidos(p[2].toString(), p[0].toString(),p[4].toString(),p[1].toString(),p[3].toString()));
        }

        AdapterPedidos pppp3 = new AdapterPedidos (getActivity(), R.layout.filas3,arrayListP);

        listapedidos.setAdapter(pppp3);
    }
}
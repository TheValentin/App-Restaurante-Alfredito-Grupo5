package com.example.restaurante_alfredito.Actividades.uiMotorizado.Lista_de_pedidos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.R;

public class lista_de_pedidosFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_lista_de_pedidos,container,false);
    }


}
package com.example.restaurante_alfredito.Actividades.uiAdministrador.Persistencia_productos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.R;

public class persistencia_productosFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_persistencia_productos,container,false);
    }


}
package com.example.restaurante_alfredito.Actividades.uiMotorizado.Inicio_motorizado;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.restaurante_alfredito.R;


public class inicio_motorizadoFragment extends Fragment {



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_inicio_motorizado,container,false);
    }


}
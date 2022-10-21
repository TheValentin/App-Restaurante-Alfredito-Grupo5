package com.example.restaurante_alfredito.Actividades.uiCliente.carrito;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restaurante_alfredito.Actividades.AdministradorMenuActivity;
import com.example.restaurante_alfredito.PasarelaPagos;
import com.example.restaurante_alfredito.R;


public class CarritoFragment extends Fragment {

    public Button BtnPasarela;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_carrito,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
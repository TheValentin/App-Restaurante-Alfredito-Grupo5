package com.example.restaurante_alfredito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdapterPedidosCliente extends ArrayAdapter<PedidosCliente> {

private Context mContext;
private int mResourse;

    public AdapterPedidosCliente(@NonNull Context context, int resource, @NonNull ArrayList<PedidosCliente> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResourse=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResourse,parent,false);


        TextView txtfecha = (TextView )  convertView.findViewById(R.id.txt_nombre_cesta);
        TextView txtcodigo =  (TextView ) convertView.findViewById(R.id.txtcodigo);
        TextView txtestado =  (TextView ) convertView.findViewById(R.id.txtestado);

        txtfecha.setText(getItem(position).getFecha());
        txtcodigo.setText(getItem(position).getCodigo());
        txtestado.setText(getItem(position).getEstado());


        return convertView;

    }
}

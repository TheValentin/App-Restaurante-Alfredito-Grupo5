package com.example.restaurante_alfredito;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AdaptaerDetalle_Pedidos extends ArrayAdapter<Productos> {

    private Context mContext;
    private int mResourse;

    public AdaptaerDetalle_Pedidos(@NonNull Context context, int resource, @NonNull ArrayList<Productos> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResourse=resource;

    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResourse,parent,false);


        ImageView imageView=  ( ImageView)convertView.findViewById(R.id.imagen_detalle);
        TextView txtnombr = (TextView )  convertView.findViewById(R.id.txt_nombre_detalle);
        TextView descrp =  (TextView ) convertView.findViewById(R.id.txt_precio_detalle);
        TextView cant =  (TextView ) convertView.findViewById(R.id.txt_cantidad_detalle);

        imageView.setImageResource(getItem(position).getImagen());
        txtnombr.setText(getItem(position).getNombre());
        descrp.setText(getItem(position).getDescrip());
        cant.setText(getItem(position).getCantidad());



        return convertView;

    }

}

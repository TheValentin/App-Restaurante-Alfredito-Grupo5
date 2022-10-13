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

public class AdapterCatalago extends ArrayAdapter<Productos> {

private Context mContext;
private int mResourse;

    public AdapterCatalago(@NonNull Context context, int resource, @NonNull ArrayList<Productos> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResourse=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResourse,parent,false);


        ImageView imageView=  ( ImageView)convertView.findViewById(R.id.imagen);
        TextView txtnombr = (TextView )  convertView.findViewById(R.id.txtnombre);
        TextView descrp =  (TextView ) convertView.findViewById(R.id.descripcion);

        imageView.setImageResource(getItem(position).getImagen());
        txtnombr.setText(getItem(position).getNombre());
        descrp.setText(getItem(position).getDescrip());


        return convertView;

    }
}

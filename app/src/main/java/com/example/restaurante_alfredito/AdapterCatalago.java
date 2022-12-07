package com.example.restaurante_alfredito;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.io.ByteArrayInputStream;
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
        TextView txtnombr = (TextView )  convertView.findViewById(R.id.txtfecha);
        TextView descrp =  (TextView ) convertView.findViewById(R.id.descripcion);


        byte[] blob = getItem(position).getImagen();
        ByteArrayInputStream bais= null;
        Bitmap bitmap= null;
        if (blob !=null){
            bais = new ByteArrayInputStream(blob);
            bitmap = BitmapFactory.decodeStream(bais);
        }
/*
        imageView.setImageBitmap(bitmap);
        /*
        imageView.setImageResource(getItem(position).getImagen());

         */


        imageView.setImageBitmap(bitmap);
        txtnombr.setText(getItem(position).getNombre());
        descrp.setText(getItem(position).getDescrip());


        return convertView;

    }
}

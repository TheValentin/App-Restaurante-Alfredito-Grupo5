package com.example.restaurante_alfredito;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.view.LayoutInflater;

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


        ImageView imageView=  ( ImageView)convertView.findViewById(R.id.imagen5);
        TextView txtnombr = (TextView )  convertView.findViewById(R.id.t);
        TextView descrp =  (TextView ) convertView.findViewById(R.id.descripcion);
Button button_detalle  =(Button) convertView.findViewById(R.id.fil_Mas_detalle);

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

///Vetana emergente
        AlertDialog dialog_buscar ;

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Detalle");
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( getContext().LAYOUT_INFLATER_SERVICE );
        View v1 = inflater.inflate( R.layout.mas_detalle, null );
        ImageView imagen_det= v1.findViewById(R.id.imageView6);
        TextView decripcion_de_plato = v1.findViewById(R.id.txt_detalle_platillo);

        imagen_det.setImageBitmap(bitmap);
        decripcion_de_plato.setText(getItem(position).getDescrip_det());
        builder.setView(v1);
        dialog_buscar=builder.create();
        button_detalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog_buscar.show();
            }
        });

///////



        return convertView;

    }


    public void dialalogo (){

    }
}

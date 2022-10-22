package com.example.restaurante_alfredito;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;



public class AdapterPedidos extends ArrayAdapter<Pedidos> {

private Context mContext;
private int mResourse;

    public AdapterPedidos(@NonNull Context context, int resource, @NonNull ArrayList<Pedidos> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResourse=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResourse,parent,false);


        TextView txtfecha = (TextView )  convertView.findViewById(R.id.txtfecha);
        TextView txtcodigo =  (TextView ) convertView.findViewById(R.id.txtcodigo);
        TextView txtestado =  (TextView ) convertView.findViewById(R.id.txtestado);
        TextView txtcliente =  (TextView ) convertView.findViewById(R.id.txtcliente);

        Button button = (Button ) convertView.findViewById(R.id.btn_Detalle_lista);




        txtfecha.setText(getItem(position).getFecha());
        txtcodigo.setText(getItem(position).getCodigo());
        txtestado.setText(getItem(position).getEstado());
        txtcliente.setText(getItem(position).getCliente());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2 = new Intent(getContext(),Detalle_PedidosActivity.class);
                mContext.startActivity(intent2 );
            }
        });
        return convertView;

    }
}

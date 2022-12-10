package com.example.restaurante_alfredito;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.restaurante_alfredito.Actividades.ClienteMenuActivity;
import com.example.restaurante_alfredito.Actividades.uiCliente.lista_de_comidas.Lista_de_comidasFragment;
import com.example.restaurante_alfredito.servicios.ServicioPedido;
import com.example.restaurante_alfredito.servicios.ServicioPedidoImp;

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


        ImageView imageView=  ( ImageView)convertView.findViewById(R.id.imagen555);
        TextView txtnombr = (TextView )  convertView.findViewById(R.id.t);
        Spinner descrp =  (Spinner  ) convertView.findViewById(R.id.lista_cantidad_productos);
        Button button_detalle  =(Button) convertView.findViewById(R.id.fil_Mas_detalle);
        Button button_agregar  =(Button) convertView.findViewById(R.id.fil_Mas_agregar);


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

        //SPINNER
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext() ,android.R.layout.simple_spinner_item,getItem(position).opciones);
        descrp.setAdapter(arrayAdapter);



        descrp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                if (adapterView.getItemAtPosition(i).equals("1")){

                    String [] opciones1 = {"1","2"};
                    Lista_de_comidasFragment.arrayList33 .get(position).setOpciones(opciones1 );


                }
                if (adapterView.getItemAtPosition(i).equals("2")){

                    String [] opciones1 = {"2","1",};
                    Lista_de_comidasFragment.arrayList33 .get(position).setOpciones(opciones1 );
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });




        button_agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Productos a =(Productos) Lista_de_comidasFragment.arrayList33.get(position);

                Object []op=a.getOpciones();

                ClienteMenuActivity.arrayList2_CESTA =
                        ClienteMenuActivity.servp.agregarPedido(getContext(),a.getNombre(),op[0].toString());

            }
        });


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

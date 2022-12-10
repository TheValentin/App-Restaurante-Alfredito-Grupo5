package com.example.restaurante_alfredito;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.restaurante_alfredito.Actividades.ClienteMenuActivity;
import com.example.restaurante_alfredito.Actividades.uiCliente.carrito.CarritoFragment;
import com.example.restaurante_alfredito.servicios.ServicioPedido;
import com.example.restaurante_alfredito.servicios.ServicioPedidoImp;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;

public class AdapterCarrito extends ArrayAdapter<Productos> {

private Context mContext;
private int mResourse;



    public AdapterCarrito(@NonNull Context context, int resource, @NonNull ArrayList<Productos> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResourse=resource;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResourse,parent,false);


        ImageView imageView=  ( ImageView)convertView.findViewById(R.id.imageView_carrito);
        TextView txtnombr = (TextView )  convertView.findViewById(R.id.txt_nombre_cesta);
        TextView precio =  (TextView ) convertView.findViewById(R.id.txt_precio_cesta);
        TextView cant =  (TextView ) convertView.findViewById(R.id.txt_cantidad_cesta);
        TextView importe =  (TextView ) convertView.findViewById(R.id.txt_cantidad_importe);

         Button Quitar = (Button) convertView.findViewById(R.id.button_quitar_carrito);


/*
        imageView.setImageResource(getItem(position).getImagen());

 */

        byte[] blob = getItem(position).getImagen();
        ByteArrayInputStream bais= null;
        Bitmap bitmap= null;
        if (blob !=null){
            bais = new ByteArrayInputStream(blob);
            bitmap = BitmapFactory.decodeStream(bais);
        }


        imageView.setImageBitmap(bitmap);

        txtnombr.setText(getItem(position).getNombre());
        precio.setText(getItem(position).getDescrip());
        cant.setText(getItem(position).getDescrip_det());
        importe.setText(getItem(position).getImporte());

        Quitar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Productos a =(Productos)   ClienteMenuActivity.arrayList_cesta_2 .get(position);

                ClienteMenuActivity.arrayList2_CESTA=ClienteMenuActivity.servp.quitarPedido(a.getNombre());



                ClienteMenuActivity.arrayList_cesta_2.clear();
                CarritoFragment.TOTAL_preci=0;
                for (int i = 0; i < ClienteMenuActivity.arrayList2_CESTA.size(); i++) {
                    Object[] ae= (Object[]) ClienteMenuActivity.arrayList2_CESTA.get(i);


                    ClienteMenuActivity.arrayList_cesta_2 .add(new Productos( (byte[])ae[2], ae[0].toString() ,ae[1].toString(),ae[3].toString(),ae[4].toString()));
                    CarritoFragment.TOTAL_preci=CarritoFragment.TOTAL_preci+Double.parseDouble(ae[4].toString());;
                }


/*
        arrayList2.add(new Productos(R.drawable.arroz_chaufa,"arroz_chaufa","15"));
        arrayList2.add(new Productos(R.drawable.arroz_con_pollo,"arroz_con_pollo","15"));
        arrayList2.add(new Productos(R.drawable.causa,"causa","15"));
        arrayList2.add(new Productos(R.drawable.ceviche,"ceviche","15"));
*/
                CarritoFragment.pppp2 = new AdapterCarrito(mContext, R.layout.item_carrito, ClienteMenuActivity.arrayList_cesta_2 );

                CarritoFragment.listView2.setAdapter(CarritoFragment.pppp2 );
                CarritoFragment.TOTAL_PRECIO_PEDIDO.setText(""+ CarritoFragment.TOTAL_preci);




/*
        arrayList2.add(new Productos(R.drawable.arroz_chaufa,"arroz_chaufa","15"));
        arrayList2.add(new Productos(R.drawable.arroz_con_pollo,"arroz_con_pollo","15"));
        arrayList2.add(new Productos(R.drawable.causa,"causa","15"));
        arrayList2.add(new Productos(R.drawable.ceviche,"ceviche","15"));
*/


            }
        });


        return convertView;

    }
}

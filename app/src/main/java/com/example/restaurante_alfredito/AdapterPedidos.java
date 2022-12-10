package com.example.restaurante_alfredito;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.restaurante_alfredito.servicios.ServicioDetallePedido;
import com.example.restaurante_alfredito.servicios.ServicioDetallePedidoImp;
import com.example.restaurante_alfredito.servicios.ServicioPedido;
import com.example.restaurante_alfredito.servicios.ServicioPedidoImp;
import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class AdapterPedidos extends ArrayAdapter<Pedidos> {

private Context mContext;
private int mResourse;
private Vibrator vibrator;
ServicioDetallePedido sdp= new ServicioDetallePedidoImp();
ServicioPedido sp =new ServicioPedidoImp();


    public AdapterPedidos(@NonNull Context context, int resource, @NonNull ArrayList<Pedidos> objects) {
        super(context, resource, objects);
        this.mContext=context;
        this.mResourse=resource;
    }



    @SuppressLint("MissingPermission")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        vibrator= (Vibrator) mContext.getSystemService(Service.VIBRATOR_SERVICE);

        LayoutInflater layoutInflater = LayoutInflater.from(mContext);

        convertView=layoutInflater.inflate(mResourse,parent,false);


        TextView txtfecha = (TextView )  convertView.findViewById(R.id.t);
        TextView txtcodigo =  (TextView ) convertView.findViewById(R.id.txtcodigo);
        TextView txtestado =  (TextView ) convertView.findViewById(R.id.txtestado);
        TextView txtcliente =  (TextView ) convertView.findViewById(R.id.txtcliente);
        TextView txtmonto = (TextView) convertView.findViewById(R.id.txtTotal);
        Button btnDetalle = (Button) convertView.findViewById(R.id.fil_Mas_agregar);

        txtfecha.setText(getItem(position).getFecha());
        txtcodigo.setText(getItem(position).getCodigo());
        txtestado.setText(getItem(position).getEstado());
        txtcliente.setText(getItem(position).getCliente());
        txtmonto.setText(getItem(position).getTotal());




        long[] tonosIzq ={1000,2000,3000,4000};
        if (getItem(position).getCodigo()!=null || getItem(position).getCodigo().equals("") ||!getItem(position).getCodigo().isEmpty()){
            Log.i("INFOX","on - vibrador");
            vibrator.vibrate(tonosIzq, -1);// 0 indifinidamente -1
        }

        ///Vetana emergente
        AlertDialog dialog_buscar ;

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("Detalle");
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService( getContext().LAYOUT_INFLATER_SERVICE );
        View v1 = inflater.inflate( R.layout.detalle_pedido, null );
        TextInputLayout txtdetalleP = (TextInputLayout) v1.findViewById(R.id.txtdetPedido);
        Button btnConfirmar = (Button) v1.findViewById(R.id.btnConfirmar);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sdp.listarPedido(getContext(),txtcodigo.getText().toString()).size(); i++) {




            Object[] Listadetalle = (Object[])sdp.listarPedido(getContext(),txtcodigo.getText().toString()).get(i);
            sb.append(Listadetalle[0].toString());
            sb.append("\t");
            sb.append(Listadetalle[1].toString());

            sb.append("\n");




        }

        txtdetalleP.getEditText().setText(sb.toString());
        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sp.ActualizarEstado(getContext(),txtcodigo.getText().toString());
            }
        });

        builder.setView(v1);
        dialog_buscar=builder.create();
        btnDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog_buscar.show();
            }
        });


        return convertView;

    }
}

package com.example.restaurante_alfredito.Actividades.uiCliente.carrito;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.graphics.Color;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.restaurante_alfredito.Actividades.AdministradorMenuActivity;
import com.example.restaurante_alfredito.Actividades.ClienteMenuActivity;
import com.example.restaurante_alfredito.Actividades.uiCliente.lista_de_comidas.Lista_de_comidasFragment;
import com.example.restaurante_alfredito.AdapterCarrito;
import com.example.restaurante_alfredito.AdapterCatalago;
import com.example.restaurante_alfredito.PasarelaPagos;
import com.example.restaurante_alfredito.Productos;
import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.servicios.ServicioPedidoImp;

import java.util.ArrayList;


public class CarritoFragment extends Fragment {

    public Button BtnPasarela;
    public static ListView listView2;

public static TextView TOTAL_PRECIO_PEDIDO;

    public static double TOTAL_preci=0;


public static  AdapterCarrito pppp2;



    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_carrito,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ClienteMenuActivity.arrayList_cesta_2.clear();

        listView2= (ListView)view.findViewById(R.id.listapedidoscarrito);
        TOTAL_PRECIO_PEDIDO=(TextView) view.findViewById(R.id.txt_TOTAL_CARRITO);
        TOTAL_preci=0;
        for (int i = 0; i < ClienteMenuActivity.arrayList2_CESTA.size(); i++) {
            Object[] a= (Object[]) ClienteMenuActivity.arrayList2_CESTA.get(i);


            ClienteMenuActivity.arrayList_cesta_2 .add(new Productos( (byte[])a[2], a[0].toString() ,a[1].toString(),a[3].toString(),a[4].toString()));
            TOTAL_preci=TOTAL_preci+Double.parseDouble(a[4].toString());
        }


/*
        arrayList2.add(new Productos(R.drawable.arroz_chaufa,"arroz_chaufa","15"));
        arrayList2.add(new Productos(R.drawable.arroz_con_pollo,"arroz_con_pollo","15"));
        arrayList2.add(new Productos(R.drawable.causa,"causa","15"));
        arrayList2.add(new Productos(R.drawable.ceviche,"ceviche","15"));
*/
        pppp2 = new AdapterCarrito(getActivity(), R.layout.item_carrito, ClienteMenuActivity.arrayList_cesta_2 );

        listView2.setAdapter(pppp2);
        TOTAL_PRECIO_PEDIDO.setText(""+TOTAL_preci);

        BtnPasarela=(Button) view.findViewById(R.id.BtnPasarela);




        BtnPasarela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Estas Seguro de ")
                        .setConfirmText("Confirmar")
                        .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();

                          //
                                ClienteMenuActivity.servp.Grabar_pedido(getContext(),
                                        ClienteMenuActivity.servp.Obtener_codigo_audo_Pedido(getContext()),
                                        ClienteMenuActivity.IDCliente.toString(),""+TOTAL_preci
                                );
                                ClienteMenuActivity.arrayList_cesta_2.clear();
                                ClienteMenuActivity.arrayList2_CESTA.clear();
                                ClienteMenuActivity.servp=null;
                                ClienteMenuActivity.servp=new ServicioPedidoImp();

                                for (int i = 0; i < ClienteMenuActivity.arrayList2_CESTA.size(); i++) {
                                    Object[] a= (Object[]) ClienteMenuActivity.arrayList2_CESTA.get(i);


                                    ClienteMenuActivity.arrayList_cesta_2 .add(new Productos( (byte[])a[2], a[0].toString() ,a[1].toString(),a[3].toString(),a[4].toString()));
                                    TOTAL_preci=TOTAL_preci+Double.parseDouble(a[4].toString());
                                }


                                pppp2 = new AdapterCarrito(getActivity(), R.layout.item_carrito, ClienteMenuActivity.arrayList_cesta_2 );

                                listView2.setAdapter(pppp2);
                                TOTAL_PRECIO_PEDIDO.setText(""+TOTAL_preci);
                                TOTAL_preci=0;
                                TOTAL_PRECIO_PEDIDO.setText(""+TOTAL_preci);
                                new SweetAlertDialog(getContext(),SweetAlertDialog.SUCCESS_TYPE)
                                        .setTitleText("Se guardo El pedido")
                                        .show();

                            }
                        })
                        .setCancelButton("Cancelar", new SweetAlertDialog.OnSweetClickListener() {
                            @Override
                            public void onClick(SweetAlertDialog sDialog) {
                                sDialog.dismissWithAnimation();

                                new SweetAlertDialog(getContext(),SweetAlertDialog.ERROR_TYPE)
                                        .setTitleText("Cancelado")
                                        .show();


                            }
                        })
                        .show();













            }
        });

    }
}
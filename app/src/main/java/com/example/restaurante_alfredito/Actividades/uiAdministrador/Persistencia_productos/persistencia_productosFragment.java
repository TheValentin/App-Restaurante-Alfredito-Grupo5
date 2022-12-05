package com.example.restaurante_alfredito.Actividades.uiAdministrador.Persistencia_productos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;


import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.servicios.ServicioProducto;
import com.example.restaurante_alfredito.servicios.ServicioProductoImp;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import cn.pedant.SweetAlert.SweetAlertDialog;
import android.graphics.Color;



public class persistencia_productosFragment extends Fragment implements View.OnFocusChangeListener {

    private static final int REQUERIR_PERMISOS =1000;
    private static final int REQ_CAMERA = 1001 ;
ImageView foto_producto;
Button tomar_captura, guardar_prod , eliminar_prod;
TextInputLayout id ,nomb, stoc, cate, precio;

ServicioProducto servicioProducto;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        solicitarPermisos();
        return inflater.inflate(R.layout.fragment_persistencia_productos,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        solicitarPermisos();
        servicioProducto= new ServicioProductoImp();

        foto_producto=(ImageView)view.findViewById(R.id.img_producto_persistencia);
        tomar_captura=(Button) view.findViewById(R.id.btn_capturar_imagen);
        guardar_prod=(Button) view.findViewById(R.id.btn_persistencia_guardar_o_actualizar_producto);
        eliminar_prod=(Button) view.findViewById(R.id.btn_persistencia_Eliminar_producto);

        id = (TextInputLayout)view.findViewById(R.id.txt_persistencia_id_productos) ;
        id.getEditText().setOnFocusChangeListener(this);

        nomb =(TextInputLayout)view.findViewById(R.id.txt_persistencia_nombre_productos) ;
        stoc=(TextInputLayout)view.findViewById(R.id.txt_persistencia_stock_productos) ;
        cate=(TextInputLayout)view.findViewById(R.id.txt_persistencia_categoria_productos) ;
        precio=(TextInputLayout)view.findViewById(R.id.txt_persistencia_precio_productos) ;

        ///////////////////
        tomar_captura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarPermisos();

                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQ_CAMERA);  //activando camara pero

            }
        });
/////////////////////////////////////////

        guardar_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

if (guardar_prod.getText().equals("GUARDAR")){
    byte[] byteArray =null;
    BitmapDrawable drawable = (BitmapDrawable) foto_producto.getDrawable();
    Bitmap bitmap = drawable.getBitmap();
    if(bitmap !=null){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap .compress(Bitmap.CompressFormat.PNG, 100, stream);
          byteArray = stream.toByteArray();
        bitmap.recycle();
    }

    servicioProducto.grabarProducto(getActivity(),
            id.getEditText().getText().toString(),
            nomb.getEditText().getText().toString(),
            Integer.parseInt(stoc.getEditText().getText().toString()),
            cate.getEditText().getText().toString(),
            Double.parseDouble(precio.getEditText().getText().toString()),
            byteArray
    );
    limpiaCajas2(false);


}else if(guardar_prod.getText().equals("ACTUALIZAR")){

    byte[] byteArray =null;
    BitmapDrawable drawable = (BitmapDrawable) foto_producto.getDrawable();
    Bitmap bitmap = drawable.getBitmap();
    if(bitmap !=null){
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap .compress(Bitmap.CompressFormat.PNG, 100, stream);
        byteArray = stream.toByteArray();
        bitmap.recycle();
    }

    servicioProducto.ActualizarProducto(getActivity(),
            id.getEditText().getText().toString(),
            nomb.getEditText().getText().toString(),
            Integer.parseInt(stoc.getEditText().getText().toString()),
            cate.getEditText().getText().toString(),
            Double.parseDouble(precio.getEditText().getText().toString()),
            byteArray
    );
    limpiaCajas2(false);

}


            }
        });

        eliminar_prod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                servicioProducto.eliminarProducto(getContext(),id.getEditText().getText().toString());
                limpiaCajas2(false);


            }
        });


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode==REQ_CAMERA && resultCode==-1) { // ver si acepto
            Bitmap foto = (Bitmap) data.getExtras().get("data");
            foto_producto.setImageBitmap(foto);
        }
    }

    private void solicitarPermisos() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) ==
                    PackageManager.PERMISSION_DENIED) {

                ActivityCompat.requestPermissions(getActivity(),
                        new String[]{Manifest.permission.CAMERA}, REQUERIR_PERMISOS);
            }
        }
    }


    @Override
    public void onFocusChange(View view, boolean b) {
        if (!b){
            buscarItem();
        }
    }

    private void buscarItem() {
  Object[] b = servicioProducto.Buscar_Producto(getActivity(),id.getEditText().getText().toString());

  if (b!=null){
      nomb.getEditText().setText(b[1].toString());
      stoc.getEditText().setText(b[2].toString());
      cate.getEditText().setText(b[3].toString());
      precio.getEditText().setText(b[4].toString());

      byte[] blob = (byte[]) b[5];
      ByteArrayInputStream bais= null;
      Bitmap bitmap= null;
      if (blob !=null){
           bais = new ByteArrayInputStream(blob);
          bitmap = BitmapFactory.decodeStream(bais);
      }

      foto_producto.setImageBitmap(bitmap);

      new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE)
              .setTitleText("Producto Encontrado")
              .show();
      
      guardar_prod.setText("ACTUALIZAR");
      eliminar_prod.setEnabled(true);
  }else {
      limpiaCajas(false);
      guardar_prod.setText("GUARDAR");
      eliminar_prod.setEnabled(false);

  }


    }

    private void limpiaCajas(boolean limpiarCodigo) {
        if (limpiarCodigo){
            id.getEditText().setText("");

        }
        nomb.getEditText().setText("");
        stoc.getEditText().setText("");
        cate.getEditText().setText("");
        precio.getEditText().setText("");
        foto_producto.setImageBitmap(null);

    }

    private void limpiaCajas2(boolean limpiarCodigo) {
        if (limpiarCodigo){


        }
        id.getEditText().setText("");
        nomb.getEditText().setText("");
        stoc.getEditText().setText("");
        cate.getEditText().setText("");
        precio.getEditText().setText("");
        foto_producto.setImageBitmap(null);
        id.getEditText().setOnFocusChangeListener(this);
    }
}
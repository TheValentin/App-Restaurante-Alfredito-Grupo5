package com.example.restaurante_alfredito.Actividades.uiMotorizado.Inicio_motorizado;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;

import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.servicios.ServicioMotorizado;
import com.example.restaurante_alfredito.servicios.ServicioMotorizadoImp;
import com.google.android.material.textfield.TextInputLayout;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import cn.pedant.SweetAlert.SweetAlertDialog;


public class inicio_motorizadoFragment extends Fragment {


    private static final int REQUERIR_PERMISOS =1000;
    private static final int REQ_CAMERA = 1001 ;
    private static final int REQ_CAMERA_GALERIA = 1002 ;

    private TextInputLayout txtIDmotrizado ,txtnombre,txtapellido,txtdni,txttelefono,txtusuario,txtcontrasena;
    private Button btnActualizar, tomar_captura,ir_almacenamiento ;

    ImageView foto_Empleado;

    ServicioMotorizado servicioMotorizado;

    ListView listahistorial;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        solicitarPermisos();
        return inflater.inflate(R.layout.fragment_inicio_motorizado,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        solicitarPermisos();
        servicioMotorizado=new ServicioMotorizadoImp();

        txtIDmotrizado=(TextInputLayout) view.findViewById(R.id.txtIdMotorizado_inicioEmpleado);
        txtnombre=(TextInputLayout) view.findViewById(R.id.txtnombre_inicioEmpleado);
        txtapellido=(TextInputLayout) view.findViewById(R.id.txtApellido_inicioEmpleado);
        txtdni=(TextInputLayout) view.findViewById(R.id.txtDni_inicioEmpleado);
        txttelefono=(TextInputLayout) view.findViewById(R.id.txtTelefono_inicioEmpleado);
        txtusuario=(TextInputLayout) view.findViewById(R.id.txtusuario_inicioEmpleado);
        txtcontrasena=(TextInputLayout) view.findViewById(R.id.txtContrasena_inicioEmpleado);

        foto_Empleado=(ImageView) view.findViewById(R.id.Imagen_Empleado_Inicio);
        tomar_captura=(Button) view.findViewById(R.id.BtnEditarfoto_iniciiEmpleado);
        ir_almacenamiento=(Button) view.findViewById(R.id.BtnGaleriaInicio_empleado);
        btnActualizar=(Button) view.findViewById(R.id.btnActualizar_inicioEmpleado);

        tomar_captura.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                solicitarPermisos();

                Intent intent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQ_CAMERA);
            }
        });

        ir_almacenamiento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                intent.setType("image/");
                startActivityForResult(Intent.createChooser(intent,"Seleccione la aplicacion"),REQ_CAMERA_GALERIA);

            }
        });

        btnActualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                byte[] byteArray =null;
                BitmapDrawable drawable = (BitmapDrawable) foto_Empleado.getDrawable();
                Bitmap bitmap = drawable.getBitmap();
                if(bitmap !=null){
                    ByteArrayOutputStream stream = new ByteArrayOutputStream();
                    bitmap .compress(Bitmap.CompressFormat.PNG, 100, stream);
                    byteArray = stream.toByteArray();
                    bitmap.recycle();

                }



                servicioMotorizado.ActualizarEmpleado(getActivity(),txtIDmotrizado.getEditText().getText().toString(), txtnombre.getEditText().getText().toString(),txtapellido.getEditText().getText().toString(),txtdni.getEditText().getText().toString(),txttelefono.getEditText().getText().toString(),byteArray,txtusuario.getEditText().getText().toString(),txtcontrasena.getEditText().getText().toString());


                new SweetAlertDialog(getActivity(),SweetAlertDialog.SUCCESS_TYPE)
                        .setTitleText("Registro Actualizado")
                        .show();




            }


        });






    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==REQ_CAMERA && resultCode==-1) { // ver si acepto
            Bitmap foto = (Bitmap) data.getExtras().get("data");
            foto_Empleado.setImageBitmap(foto);
        }else if (requestCode==REQ_CAMERA_GALERIA && resultCode==-1){

            Uri path=data.getData();
            foto_Empleado.setImageURI(path);

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
}
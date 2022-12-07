package com.example.restaurante_alfredito.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;


import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.antivity_iniciar1;
import com.example.restaurante_alfredito.databinding.ActivityMotorizadoBinding;
import com.example.restaurante_alfredito.servicios.ServicioMotorizado;
import com.example.restaurante_alfredito.servicios.ServicioMotorizadoImp;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.textfield.TextInputLayout;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;



public class MotorizadoMenuActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMotorizadoBinding binding;

    private TextInputLayout txtIDmotrizado ,txtnombre,txtapellido,txtdni,txttelefono,txtusuario,txtcontrasena;
    private byte foto;

    ServicioMotorizado serv_m ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMotorizadoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMotorizado.toolbar);
        binding.appBarMotorizado.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_inicio_motorizado, R.id.nav_lista_pedidos, R.id.nav_mapa_de_entrega)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_motorizado);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        txtIDmotrizado=(TextInputLayout) findViewById(R.id.txtIdMotorizado_inicioEmpleado);
        txtnombre=(TextInputLayout) findViewById(R.id.txtnombre_inicioEmpleado);
        txtapellido=(TextInputLayout) findViewById(R.id.txtApellido_inicioEmpleado);
        txtdni=(TextInputLayout) findViewById(R.id.txtDni_inicioEmpleado);
        txttelefono=(TextInputLayout) findViewById(R.id.txtTelefono_inicioEmpleado);
        txtusuario=(TextInputLayout) findViewById(R.id.txtusuario_inicioEmpleado);
        txtcontrasena=(TextInputLayout) findViewById(R.id.txtContrasena_inicioEmpleado);



        serv_m = new ServicioMotorizadoImp();
        Bundle bundle = getIntent().getExtras();

        if (bundle!=null){
            String usuarioMotorizado= bundle.getString("usuarioMotorizado", "0");
            String contrasenaMotorizado= bundle.getString("contrasenaMotorizado", "0");

            Object[] fil_M = serv_m .validarMotorizado(this,usuarioMotorizado,contrasenaMotorizado);
            txtIDmotrizado.getEditText().setText(""+fil_M[0]);
            txtnombre.getEditText().setText(""+fil_M[1]);
            txtapellido.getEditText().setText(""+fil_M[2]);
            txtdni.getEditText().setText(""+fil_M[3]);
            txttelefono.getEditText().setText(""+fil_M[4]);
            txtusuario.getEditText().setText(""+fil_M[6]);
            txtcontrasena.getEditText().setText(""+fil_M[7]);

        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.motorizado_menu, menu);
        return true;
    }

    //metodo para cerrar sesion
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cerrar_sesion_motorizado:
                ///
                Intent siguiente6 = new Intent(MotorizadoMenuActivity.this, antivity_iniciar1.class);
                startActivity(siguiente6);
                break;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_motorizado);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
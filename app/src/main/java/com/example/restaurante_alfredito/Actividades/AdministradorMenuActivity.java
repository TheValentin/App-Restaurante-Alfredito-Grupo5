package com.example.restaurante_alfredito.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ImageView;


import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.antivity_iniciar1;
import com.example.restaurante_alfredito.databinding.ActivityAdministradorMenuBinding;
import com.example.restaurante_alfredito.servicios.ServicioAdministrador;
import com.example.restaurante_alfredito.servicios.ServicioAdministradorImp;
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




public class AdministradorMenuActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityAdministradorMenuBinding binding;

    private TextInputLayout txtIDadmin ,txtnombre,txtapellido,txtdni,txttelefono,txtusuario,txtcontrasena;
    private ImageView foto;

    ServicioAdministrador serv_a ;

    public static String IDAdministrador="00";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        IDAdministrador=bundle.getString("IDAdministrador", "0");;

        binding = ActivityAdministradorMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarAdministradorMenu.toolbar);
        binding.appBarAdministradorMenu.fab.setOnClickListener(new View.OnClickListener() {
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
                R.id.nav_inicio_administrador, R.id.nav_persistencia_empleados, R.id.nav_persistencia_productos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_administrador_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        txtIDadmin=(TextInputLayout) findViewById(R.id.txtIdAdmin_inicioAdmin);
        txtnombre=(TextInputLayout) findViewById(R.id.txtNombre_inicioAdmin);
        txtapellido=(TextInputLayout) findViewById(R.id.txtApellido_inicioAdmin);
        txtdni=(TextInputLayout) findViewById(R.id.txtDNI_inicioAdmin);
        txttelefono=(TextInputLayout) findViewById(R.id.txtTelefono_inicioAdmin);
        txtusuario=(TextInputLayout) findViewById(R.id.txtUsuario_inicioAdmin);
        txtcontrasena=(TextInputLayout) findViewById(R.id.txtContrasena_inicioAdmin);

        foto=(ImageView) findViewById(R.id.imagen_Admin_Inicio);

        serv_a = new ServicioAdministradorImp();

        if (bundle!=null){
/*
            Object[] fil_A = serv_a .validarAdministrador(this,usuarioAdmin,contrasenaAdmin);
            txtIDadmin.getEditText().setText(""+fil_A[0]);
            txtnombre.getEditText().setText(""+fil_A[1]);
            txtapellido.getEditText().setText(""+fil_A[2]);
            txtdni.getEditText().setText(""+fil_A[3]);
            txttelefono.getEditText().setText(""+fil_A[4]);
            txtusuario.getEditText().setText(""+fil_A[6]);
            txtcontrasena.getEditText().setText(""+fil_A[7]);
*/
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.administrador_menu, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_administrador_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    //metodo para cerrar sesion
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cerrar_sesion_administrador:
               ///
                Intent siguiente4 = new Intent(AdministradorMenuActivity.this, antivity_iniciar1.class);
                startActivity(siguiente4);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
}
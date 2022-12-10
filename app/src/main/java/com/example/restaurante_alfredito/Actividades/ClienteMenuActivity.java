package com.example.restaurante_alfredito.Actividades;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Button;


import com.example.restaurante_alfredito.PasarelaPagos;
import com.example.restaurante_alfredito.Productos;
import com.example.restaurante_alfredito.R;
import com.example.restaurante_alfredito.antivity_iniciar1;
import com.example.restaurante_alfredito.databinding.ActivityClienteMenuBinding;
import com.example.restaurante_alfredito.servicios.ServicioClientes;
import com.example.restaurante_alfredito.servicios.ServicioClientesImp;
import com.example.restaurante_alfredito.servicios.ServicioPedido;
import com.example.restaurante_alfredito.servicios.ServicioPedidoImp;
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

import java.util.ArrayList;


public class ClienteMenuActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityClienteMenuBinding binding;

    private TextInputLayout txtIDcliente ,txtnombre,txtapellido,txtdni,txttelefono,txtcorreo,txtdireccion,txtusuario,txtcontrasena;

    ServicioClientes serv_c ;

    public static String IDCliente="00";

    public  static ArrayList arrayList2_CESTA = new ArrayList() ;

    public static ArrayList<Productos> arrayList_cesta_2 = new ArrayList<>();

    public static ServicioPedido servp = new ServicioPedidoImp();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle bundle = getIntent().getExtras();
        IDCliente=bundle.getString("IDCliente", "0");;

        binding = ActivityClienteMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarClienteMenu.toolbar);

        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_inicio_cliente, R.id.nav_lista_comidas, R.id.nav_Carrito, R.id.nav_historial_pedidos)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_cliente_menu);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        txtIDcliente=(TextInputLayout) findViewById(R.id.txtIdCliente_inicioCliente);
        txtnombre=(TextInputLayout) findViewById(R.id.txtNombre_inicioCliente);
        txtapellido=(TextInputLayout) findViewById(R.id.txtApellido_inicioCliente);
        txtdni=(TextInputLayout) findViewById(R.id.txtDNI_inicioCliente);
        txttelefono=(TextInputLayout) findViewById(R.id.txtTelefono_inicioCliente);
        txtcorreo=(TextInputLayout) findViewById(R.id.txtCorreo_inicioCliente);
        txtdireccion=(TextInputLayout) findViewById(R.id.txtDireccion_inicioCliente);
        txtusuario=(TextInputLayout) findViewById(R.id.txtUsuario_inicioCliente);
        txtcontrasena=(TextInputLayout) findViewById(R.id.txtContrasena_inicioCliente);

        serv_c = new ServicioClientesImp();

        if (bundle!=null){

/*
            String usuarioClientes= bundle.getString("usuarioClientes", "0");
            String contrasenaClientes= bundle.getString("contrasenaClientes", "0");

            Object[] fil_C = serv_c .validarClientes(this,usuarioClientes,contrasenaClientes);

            txtIDcliente.getEditText().setText(fil_C[0].toString());
            txtnombre.getEditText().setText(""+fil_C[1]);
            txtapellido.getEditText().setText(""+fil_C[2]);
            txtdni.getEditText().setText(""+fil_C[3]);
            txttelefono.getEditText().setText(""+fil_C[4]);
            txtcorreo.getEditText().setText(""+fil_C[5]);
            txtdireccion.getEditText().setText(""+fil_C[6]);
            txtusuario.getEditText().setText(""+fil_C[7]);
            txtcontrasena.getEditText().setText(""+fil_C[8]);

*/
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cliente_menu, menu);
        return true;
    }


    //metodo para cerrar sesion
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.cerrar_sesion_cliente:
                ///
                Intent siguiente5 = new Intent(ClienteMenuActivity.this, antivity_iniciar1.class);
                startActivity(siguiente5);
                break;

        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_cliente_menu);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}
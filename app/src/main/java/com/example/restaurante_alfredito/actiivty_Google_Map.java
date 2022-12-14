package com.example.restaurante_alfredito;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;



import androidx.annotation.Nullable;

import androidx.core.app.ActivityCompat;


import android.Manifest;
import android.content.Intent;
import android.content.IntentSender;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.Button;


import com.example.restaurante_alfredito.Actividades.AdministradorMenuActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationSettingsRequest;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.restaurante_alfredito.databinding.ActivityGoogleMapBinding;


import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.ResolvableApiException;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsResponse;
import com.google.android.gms.location.LocationSettingsStatusCodes;
import com.google.android.gms.location.SettingsClient;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import java.util.HashMap;
import java.util.Map;

import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CustomCap;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.JointType;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.RoundCap;
import com.google.android.libraries.places.api.Places;
import com.google.android.libraries.places.api.model.Place;
import com.google.android.libraries.places.widget.Autocomplete;
import com.google.android.libraries.places.widget.model.AutocompleteActivityMode;

import java.util.Arrays;
import java.util.List;


public class actiivty_Google_Map extends FragmentActivity implements OnMapReadyCallback {



    // Estado del Settings de verificaci??n de permisos del GPS
    private static final int REQUEST_CHECK_SETTINGS = 102;

    // La clase FusedLocationProviderClient
    private FusedLocationProviderClient fusedLocationClient;

    // La clase LocationCallback se utiliza para recibir notificaciones de FusedLocationProviderApi
    // cuando la ubicaci??n del dispositivo ha cambiado o ya no se puede determinar.
    private LocationCallback mlocationCallback;

    // La clase LocationSettingsRequest.Builder extiende un Object
    // y construye una LocationSettingsRequest.
    private LocationSettingsRequest.Builder builder;

    // La clase LocationRequest sirve para  para solicitar las actualizaciones
    // de ubicaci??n de FusedLocationProviderApi
    public LocationRequest mLocationRequest;

    // Marcador para la ubicaci??n del usuario
    Marker marker;
    Marker marker1;

    // Mapa de Google
    private GoogleMap mMap;

    private TextView mi_ubicacion;

    //private ActivityGoogleMapBinding binding;


    private static int AUTOCOMPLETE_REQUEST_CODE = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_google_map);
        mi_ubicacion=(TextView)findViewById(R.id.txtDireccion_inicioCliente);





        //prueba //
        Places.initialize(getApplicationContext(), getString(R.string.google_key));

        //prueba //


        /*
        binding = ActivityGoogleMapBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
*/
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        // Hago uso de FusedLocationProviderClient
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        // M??todo para obtener la ??ltima ubicaci??n del usuario
        obtenerUltimaUbicacion();

        // Con LocationCallback enviamos notificaciones de la ubicaci??n del usuario
        mlocationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {

                // Si no hay coordenadas de la ubicaci??n del usuario le pasamos un return
                if (locationResult == null) {
                    return;
                }

                // Cuando obtenemos la coordenadas de ubicaci??n del usuario, agregamos
                // un marcador para la ubicaci??n del usuario con el m??todo agregarMarcador()
                // el cual crear?? m??s adelante
                for (Location location : locationResult.getLocations()) {
                    marcadorRestaruante();
                    agregarMarcador(location.getLatitude(),location.getLongitude());
                    ruta(location.getLatitude(),location.getLongitude());


                    Log.e("Coordenadas: ", "Latitud: "+location.getLatitude()+" longitud: "+location.getLongitude());


                    //////////////////////////////////////////////////aqui tomamos los datos para el firebase///////////////////////////////////////////////////////////////////

                    Map<String,Object> latlang=new HashMap<>();

                    latlang.put("latitud",location.getLatitude());
                    latlang.put("longitud",location.getLongitude());
                   // mDatabase.child("usuario").push().setValue(latlang); //Envio a la firebase los datos




                }

            };
        };

        // Obtenemos actualizaciones de la ubicaci??n del usuario
        mLocationRequest = createLocationRequest();

        // Construimos un LocationSettingsRequest
        builder = new LocationSettingsRequest.Builder()
                .addLocationRequest(mLocationRequest);

        // Verificamos la configuraci??n de los permisos de ubicaci??n
        checkLocationSetting(builder);

        //Agregar nuecos
        createLocationRequest();


    }
    private void completo(){
        List<Place.Field> fields = Arrays.asList(Place.Field.ID, Place.Field.NAME);

        // Start the autocomplete intent.
        Intent intent = new Autocomplete.IntentBuilder(AutocompleteActivityMode.FULLSCREEN, fields)
                .build(this);
        startActivityForResult(intent, AUTOCOMPLETE_REQUEST_CODE);
    }



    private void agregarMarcador(double lat, double lng) {

        LatLng coordenadas = new LatLng(lat, lng);
        CameraUpdate miUbicacion = CameraUpdateFactory.newLatLngZoom(coordenadas, 15);
        if (marker != null) marker.remove();
        marker = mMap.addMarker(new MarkerOptions()
                .position(coordenadas)
                .title("Tu posici??n")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.iconousuario)));
        mMap.animateCamera(miUbicacion);

    }

    private void marcadorRestaruante(){
        LatLng coordenadas2 = new LatLng(-12.0249955, -77.0970169);
        CameraUpdate miUbicacion2 = CameraUpdateFactory.newLatLngZoom(coordenadas2, 15);
        if (marker1 != null) marker1.remove();
        marker1 = mMap.addMarker(new MarkerOptions()
                .position(coordenadas2)
                .title("Restaurante")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.moto_removebg_preview)).anchor(0.0f,1.0f));
        mMap.animateCamera(miUbicacion2);
    }



    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */


    public void ruta(double lat, double lng){ //recta
        Polyline polyline1 = mMap.addPolyline(new PolylineOptions()
                .clickable(true)
                .add(
                        new LatLng(lat,lng), // mi ubicacion
                        new LatLng(-12.0249955, -77.0970169))); //restauramte

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

    }





//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    private void obtenerUltimaUbicacion() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                // muestra una ventana o Dialog en donde el usuario debe
                // dar permisos para el uso del GPS de su dispositivo.
                dialogoSolicitarPermisoGPS();

            }
        }

    }

    ////////////////////////////
    protected LocationRequest createLocationRequest() {
        LocationRequest mLocationRequest = LocationRequest.create();
        mLocationRequest.setInterval(30000);
        mLocationRequest.setFastestInterval(10000);
        mLocationRequest.setSmallestDisplacement(30);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        return mLocationRequest;
    }
    private void checkLocationSetting(LocationSettingsRequest.Builder builder) {

        builder.setAlwaysShow(true);

        // Dentro de la variable 'cliente' iniciamos LocationServices, para los servicios de ubicaci??n
        SettingsClient cliente = LocationServices.getSettingsClient(this);

        // Creamos una task o tarea para verificar la configuraci??n de ubicaci??n del usuario
        Task<LocationSettingsResponse> task = cliente.checkLocationSettings(builder.build());

        // Adjuntamos OnSuccessListener a la task o tarea
        task.addOnSuccessListener(this, new OnSuccessListener<LocationSettingsResponse>() {
            @Override
            public void onSuccess(LocationSettingsResponse locationSettingsResponse) {

                // Si la configuraci??n de ubicaci??n es correcta,
                // se puede iniciar solicitudes de ubicaci??n del usuario
                // mediante el m??todo iniciarActualizacionesUbicacion() que crear?? m??s abajo.
                iniciarActualizacionesUbicacion();

            }
        });

        // Adjuntamos addOnCompleteListener a la task para gestionar si la tarea se realiza correctamente
        task.addOnCompleteListener(new OnCompleteListener<LocationSettingsResponse>() {

            @Override
            public void onComplete(Task<LocationSettingsResponse> task) {
                try {
                    LocationSettingsResponse response = task.getResult(ApiException.class);
                    // En try podemos hacer 'algo', si la configuraci??n de ubicaci??n es correcta,

                } catch (ApiException exception) {
                    switch (exception.getStatusCode()) {
                        case LocationSettingsStatusCodes.RESOLUTION_REQUIRED:

                            // La configuraci??n de ubicaci??n no est?? satisfecha.
                            // Le mostramos al usuario un di??logo de confirmaci??n de uso de GPS.
                            try {
                                // Transmitimos a una excepci??n resoluble.
                                ResolvableApiException resolvable = (ResolvableApiException) exception;

                                // Mostramos el di??logo llamando a startResolutionForResult()
                                // y es verificado el resultado en el m??todo onActivityResult().
                                resolvable.startResolutionForResult(
                                        actiivty_Google_Map.this,
                                        REQUEST_CHECK_SETTINGS);
                            } catch (IntentSender.SendIntentException e) {
                                // Ignora el error.
                            } catch (ClassCastException e) {
                                // Ignorar, aca podr??a ser un error imposible.
                            }
                            break;
                        case LocationSettingsStatusCodes.SETTINGS_CHANGE_UNAVAILABLE:
                            // La configuraci??n de ubicaci??n no est?? satisfecha
                            // podemos hacer algo.
                            break;
                    }
                }
            }
        });

    }
    public void iniciarActualizacionesUbicacion() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    Activity#requestPermissions
                return;
            }
        }

        // Obtenemos la ubicaci??n m??s reciente
        fusedLocationClient.requestLocationUpdates(mLocationRequest,
                mlocationCallback,
                null /* Looper */);
    }

    private void stopLocationUpdates() {
        fusedLocationClient.removeLocationUpdates(mlocationCallback);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CHECK_SETTINGS) {
            if (resultCode == RESULT_OK) {
                // Se cumplen todas las configuraciones de ubicaci??n.
                // La aplicaci??n env??a solicitudes de ubicaci??n del usuario.
                iniciarActualizacionesUbicacion();
            } else {
                checkLocationSetting(builder);
            }
        }
    }
    private void dialogoSolicitarPermisoGPS(){
        if (ActivityCompat.checkSelfPermission(actiivty_Google_Map.this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(actiivty_Google_Map.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(actiivty_Google_Map.this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION}, 123);
        }
    }
    public void EnviarMensaje(View v){
        Intent intent = new Intent(this, Mensajeria.class);
        startActivity(intent);
    }


}
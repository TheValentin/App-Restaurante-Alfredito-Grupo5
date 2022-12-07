package com.example.restaurante_alfredito.DAO;

import static androidx.test.InstrumentationRegistry.getContext;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.restaurante_alfredito.dto.Motorizado;
import com.example.restaurante_alfredito.dto.Producto;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.util.ArrayList;
import java.util.List;

public class DaoMotorizadoImp implements  DaoMotorizado  {


    private SQLiteDatabase db ;

    @SuppressLint("Range")
    @Override
    public ArrayList<Motorizado> ListarMotorizado(Context context) {

        ArrayList<Motorizado> list  =  new ArrayList<>();
        Motorizado M= null;
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        String cadSQL="select *  from motorizado";

        Cursor c =db.rawQuery(cadSQL,null);
        StringBuilder sb = new StringBuilder();
        if (c!=null){
            if (c.moveToFirst()){
                do{
                    M = new Motorizado();
                    M.setIdmotorizado(c.getString(0));
                    M.setNombre(c.getString(1));
                    M.setApellido(c.getString(2));
                    M.setDni(c.getString(3));
                    M.setTelefono(c.getString(4));
                    M.setUsuario(c.getString(6));
                    M.setContrasena(c.getString(7));

                    list.add(M);
                }while (c.moveToNext());
            }
            c.close();
        }else {
        }
        db.close();
        return list;
    }

    @Override
    public String CrearRegistroEmpleado(Context context, Motorizado motorizado) {

        String mensaje = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

            ContentValues registro =  new ContentValues();

            registro.put("idmotorizado",motorizado.getIdmotorizado());
            registro.put("nombre",motorizado.getNombre());
            registro.put("apellido",motorizado.getApellido());
            registro.put("dni",motorizado.getDni());
            registro.put("telefono",motorizado.getTelefono());
            registro.put("foto ",motorizado.getFoto());
            registro.put("usuario ",motorizado.getUsuario());
            registro.put("contrasena ",motorizado.getContrasena());

            long ctos =db.insert(GlobalesApp.TBL_MOTORIZADO,null,registro);
            if (ctos == 0) {
                mensaje = "cero Empleados insertadas";
            }


            db.close();
        }  catch (SQLException ex){


        }
        return mensaje;
    }

    @Override
    public String ActualizarEmpleado(Context context, Motorizado motorizado) {

        String mensaje = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD, null, GlobalesApp.VERSION).getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("idmotorizado",motorizado.getIdmotorizado());
            registro.put("nombre",motorizado.getNombre());
            registro.put("apellido",motorizado.getApellido());
            registro.put("dni",motorizado.getDni());
            registro.put("telefono",motorizado.getTelefono());
            registro.put("foto ",motorizado.getFoto());
            registro.put("usuario ",motorizado.getUsuario());
            registro.put("contrasena ",motorizado.getContrasena());


            String parametro[] = {"" + motorizado.getIdmotorizado().toString()};
            long ctos = db.update(GlobalesApp.TBL_MOTORIZADO, registro, "idmotorizado=?", parametro);

            if (ctos == 0) {
                mensaje = "cero filas Actualizadas";
            }

            db.close();
        } catch (SQLException ex) {


        }
        return mensaje;
    }

    @Override
    public Motorizado BuscarMotorizado(Context context, String id) {
        Motorizado m = new  Motorizado();
        try {
            db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getReadableDatabase();
            String cadSQL="select *  from motorizado where idmotorizado = ?";

            String codigo= id;
            String parametro[]={""+codigo};
            Cursor c = db.rawQuery(cadSQL,parametro);

            if (c!=null){
                if (c.moveToFirst()){


                    m.setIdmotorizado(c.getString(0));
                    m.setNombre(c.getString(1));
                    m.setApellido(c.getString(2));
                    m.setDni(c.getString(3));
                    m.setTelefono(c.getString(4));
                    m.setFoto(c.getBlob(5));
                    m.setUsuario(c.getString(6));
                    m.setContrasena(c.getString(7));


                }else {

                    return null;

                }
                c.close();

            }

            db.close();

        }  catch (SQLException ex){



        }



        return m;
    }


}

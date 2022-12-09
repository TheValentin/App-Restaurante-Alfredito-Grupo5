package com.example.restaurante_alfredito.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.restaurante_alfredito.dto.Administrador;
import com.example.restaurante_alfredito.servicios.ConectaDB;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

import java.util.ArrayList;

public class DaoAdministradorImp implements DaoAdministrador {

    private SQLiteDatabase db ;

    @Override
    public ArrayList<Administrador> ListarAdministrador(Context context) {
        ArrayList<Administrador> list  =  new ArrayList<>();
        Administrador M= null;
        db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

        String cadSQL="select *  from admin";

        Cursor c =db.rawQuery(cadSQL,null);
        StringBuilder sb = new StringBuilder();
        if (c!=null){
            if (c.moveToFirst()){
                do{
                    M = new Administrador ();
                    M.setIdadmin(c.getString(0));
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
    public String CrearRegistroAdmin(Context context, Administrador administrador) {

        String mensaje = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getWritableDatabase();

            ContentValues registro =  new ContentValues();

            registro.put("idadmin",administrador.getIdadmin());
            registro.put("nombre",administrador.getNombre());
            registro.put("apellido",administrador.getApellido());
            registro.put("dni",administrador.getDni());
            registro.put("telefono",administrador.getTelefono());
            registro.put("foto ",administrador.getFoto());
            registro.put("usuario ",administrador.getUsuario());
            registro.put("contrasena ",administrador.getContrasena());

            long ctos =db.insert(GlobalesApp.TBL_ADMINISTRADOR,null,registro);
            if (ctos == 0) {
                mensaje = "cero Admins insertadas";
            }
            db.close();
        }  catch (SQLException ex){
        }
        return mensaje;
    }

    @Override
    public String ActualizarAdmin(Context context, Administrador administrador) {

        String mensaje = null;
        try {
            db = new ConectaDB(context, GlobalesApp.BDD, null, GlobalesApp.VERSION).getWritableDatabase();
            ContentValues registro = new ContentValues();
            registro.put("idadmin",administrador.getIdadmin());
            registro.put("nombre",administrador.getNombre());
            registro.put("apellido",administrador.getApellido());
            registro.put("dni",administrador.getDni());
            registro.put("telefono",administrador.getTelefono());
            registro.put("foto ",administrador.getFoto());
            registro.put("usuario ",administrador.getUsuario());
            registro.put("contrasena ",administrador.getContrasena());


            String parametro[] = {"" + administrador.getIdadmin().toString()};
            long ctos = db.update(GlobalesApp.TBL_ADMINISTRADOR, registro, "idadmin=?", parametro);

            if (ctos == 0) {
                mensaje = "cero filas Actualizadas";
            }

            db.close();
        } catch (SQLException ex) {


        }
        return mensaje;
    }

    @Override
    public Administrador BuscarAdmin(Context context, String id) {
        Administrador m = new Administrador();
        try {
            db = new ConectaDB(context, GlobalesApp.BDD,null,GlobalesApp.VERSION).getReadableDatabase();
            String cadSQL="select *  from admin where idadmin = ?";

            String codigo= id;
            String parametro[]={""+codigo};
            Cursor c = db.rawQuery(cadSQL,parametro);

            if (c!=null){
                if (c.moveToFirst()){
                    m.setIdadmin(c.getString(0));
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

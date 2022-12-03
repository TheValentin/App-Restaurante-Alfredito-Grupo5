package com.example.restaurante_alfredito.SERVICIOS;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.restaurante_alfredito.DAO_Utilidad.cliente;
import com.example.restaurante_alfredito.utilidades.GlobalesApp;

public class ConectarDB extends SQLiteOpenHelper {

    public ConectarDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(GlobalesApp.DDL_TBL_CLIENTE);
        db.execSQL(GlobalesApp.DDL_TBL_ADMIN);
        db.execSQL(GlobalesApp.DDL_TBL_MOTORIZADO);
        db.execSQL(GlobalesApp.DDL_TBL_PRODUCTO);
        db.execSQL(GlobalesApp.DDL_TBL_PEDIDO);
        db.execSQL(GlobalesApp.DDL_TBL_DETALLE_PEDIDO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

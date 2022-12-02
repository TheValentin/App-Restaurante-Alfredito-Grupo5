package com.example.restaurante_alfredito.servicios;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.restaurante_alfredito.utilidades.GlobalesApp;


public class ConectaDB extends SQLiteOpenHelper {

    public ConectaDB(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(GlobalesApp.DDL_TABLA_ADMINISTRADOR);
        sqLiteDatabase.execSQL(GlobalesApp.DDL_TABLA_CLIENTES);
        sqLiteDatabase.execSQL(GlobalesApp.DDL_TABLA_MOTORIZADO);
        sqLiteDatabase.execSQL(GlobalesApp.DDL_TABLA_PRODUCTO);
        sqLiteDatabase.execSQL(GlobalesApp.DDL_TABLA_PEDIDO);
        sqLiteDatabase.execSQL(GlobalesApp.DDL_TABLA_DETALLE_PEDIDO);
    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    }

package com.example.biomatch;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBSQLiteHelper extends SQLiteOpenHelper {

    public MyDBSQLiteHelper(Context context, String nomDB, SQLiteDatabase.CursorFactory factory, int version){
        super(context, nomDB, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE cliente(_NIT INTEGER PRIMARY KEY, razon TEXT, nombres TEXT, apellidos TEXT, docu INTEGER, direccion TEXT, telefono INTEGER, fechaNac DATE)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int erDBAnterior, int verDBNueva){
        db.execSQL("DROP TABLE IF EXISTS cliente");
        db.execSQL("CREATE TABLE cliente(_NIT INTEGER PRIMARY KEY, razon TEXT, nombres TEXT, apellidos TEXT, docu INTEGER, direccion TEXT, telefono INTEGER, fechaNac DATE)");

    }
}

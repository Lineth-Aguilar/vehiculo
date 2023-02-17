package com.example.proyectofinal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.proyectofinal.DataVehiculo.Transacciones;

public class SQLiteConexion extends SQLiteOpenHelper
{
    // Constructor de clase con parametros
    public SQLiteConexion(Context context, String dbname, SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, dbname, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        // Lista de las tablas a crear
        sqLiteDatabase.execSQL(Transacciones.CreateTBVehiculos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL(Transacciones.DropTableVehiculos);
    }

}
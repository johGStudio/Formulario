package com.example.pc.formulario;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by pc on 5/08/16.
 */
public class Conexion extends SQLiteOpenHelper{




    public Conexion(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL("CREATE TABLE usuario(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "nombre text, " +
                "apellido text, " +
                "email text," +
                "password text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase database, int oldversion, int newversion){

    }
}

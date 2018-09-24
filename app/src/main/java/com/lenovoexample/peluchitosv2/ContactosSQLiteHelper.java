package com.lenovoexample.peluchitosv2;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactosSQLiteHelper extends SQLiteOpenHelper {

    String sqlCreate = "CREATE TABLE contactos (" +
            "id         INTEGER PRIMARY KEY AUTOINCREMENT, " +  //0
            "nombre     TEXT, " +                               //1
            "cantidad   TEXT, " +                               //2
            "precio     TEXT)";                                 //3

    public ContactosSQLiteHelper(Context context,
                                 String name, SQLiteDatabase.CursorFactory factory,
                                 int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(sqlCreate);              //crea la tabla-base de datos
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {      //actualizar base de datos
        db.execSQL("DROP TABLE IF EXISTS contactos");
        db.execSQL(sqlCreate);
    }
}
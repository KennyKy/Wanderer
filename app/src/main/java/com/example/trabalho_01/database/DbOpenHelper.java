package com.example.trabalho_01.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trabalho_01.database.model.User;
import com.example.trabalho_01.database.model.Trip;

public class DbOpenHelper extends SQLiteOpenHelper {

    public static final String
            DATABASE_NOME="banco.db";

    public static final int
            DB_VERSION = 1;

    public DbOpenHelper(final Context contexto){
        super(contexto, DATABASE_NOME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(User.CREATE_TABLE);
        db.execSQL(Trip.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(User.CREATE_TABLE);
        db.execSQL(Trip.CREATE_TABLE);
    }
}

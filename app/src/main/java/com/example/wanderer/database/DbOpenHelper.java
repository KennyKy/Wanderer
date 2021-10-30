package com.example.wanderer.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.wanderer.database.model.UserModel;
import com.example.wanderer.database.model.TravelModel;

public class DbOpenHelper extends SQLiteOpenHelper {

    public static final String
            DATABASE_NOME="database.db";

    public static final int
            DB_VERSION = 1;

    public DbOpenHelper(final Context context){
        super(context, DATABASE_NOME,null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UserModel.CREATE_TABLE);
        db.execSQL(TravelModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UserModel.CREATE_TABLE);
        db.execSQL(TravelModel.CREATE_TABLE);
    }
}

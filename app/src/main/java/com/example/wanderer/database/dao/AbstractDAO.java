package com.example.wanderer.database.dao;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.wanderer.database.DbOpenHelper;

public abstract class AbstractDAO {

    protected SQLiteDatabase db;
    protected DbOpenHelper db_helper;

    protected final void Open() throws SQLException {
        db = db_helper.getWritableDatabase();
    }

    protected final void Close() throws  SQLException{
        db_helper.close();
    }
}

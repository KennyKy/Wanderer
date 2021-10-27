package com.example.trabalho_01.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.trabalho_01.database.DbOpenHelper;
import com.example.trabalho_01.database.model.Trip;

public class TripsDAO extends AbstractDAO {
    private final String[]
            columns = {
            Trip.DISTANCE_IN_KMS_COLUMN,
            Trip.NUMBER_OF_PEOPLE_COLUMN,
            Trip.TOTAL_COST_COLUMN,
            Trip.USERNAME_COLUMN
    };

    public TripsDAO(final Context context) {
        db_helper = new DbOpenHelper(context);
    }

    public long Insert(Trip model) {
        long numberOfRows;

        try {
            Open();
            ContentValues values = new ContentValues();
            values.put(Trip.NUMBER_OF_PEOPLE_COLUMN, model.getNumberOfPeople());
            values.put(Trip.TOTAL_COST_COLUMN, model.getTotalCost());
            values.put(Trip.DISTANCE_IN_KMS_COLUMN, model.getDistance());
            values.put(Trip.USERNAME_COLUMN, model.getUsername());

            numberOfRows = db.insert(Trip.TABLE_NAME, null, values);
        } catch (Error e) {
            numberOfRows = 0;
        } finally {
            Close();
        }

        return numberOfRows;
    }

    public int Delete() {
        return 0;
    }

    public int Update() {
        return 0;
    }

    public Trip Select(final String username) {
        Trip model = null;

        try {
            Open();
            Cursor cursor = db.query(
                Trip.TABLE_NAME,
                columns,
                Trip.USERNAME_COLUMN + " = ?",
                new String[]{username},
                null,
                null,
                null
            );

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                model = CursorToStructure(cursor);
                break;
            }
        } catch (Error e) {

        } finally {
            Close();
        }

        return model;
    }

    public final Trip CursorToStructure(Cursor cursor) {
        Trip model = new Trip();
        model.setDistance(cursor.getInt(0));
        model.setNumberOfPeople(cursor.getInt(1));
        model.setTotalCost(cursor.getFloat(2));
        model.setUsername(cursor.getString(3));
        return model;
    }
}

package com.example.wanderer.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.wanderer.database.DbOpenHelper;
import com.example.wanderer.database.model.Travel;

import java.util.List;

public class TravelDAO extends AbstractDAO {
    private final String[]
            columns = {
            Travel.DISTANCE_IN_KMS_COLUMN,
            Travel.NUMBER_OF_PEOPLE_COLUMN,
            Travel.TOTAL_COST_COLUMN,
            Travel.USERNAME_COLUMN
    };

    public TravelDAO(final Context context) {
        db_helper = new DbOpenHelper(context);
    }

    public long Insert(Travel model) {
        long numberOfRows;

        try {
            Open();
            ContentValues values = new ContentValues();
            values.put(Travel.NUMBER_OF_PEOPLE_COLUMN, model.getNumberOfPeople());
            values.put(Travel.TOTAL_COST_COLUMN, model.getTotalCost());
            values.put(Travel.DISTANCE_IN_KMS_COLUMN, model.getDistance());
            values.put(Travel.USERNAME_COLUMN, model.getUsername());

            numberOfRows = db.insert(Travel.TABLE_NAME, null, values);
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

    public List<Travel>  Select(final String username) {
        List<Travel> travels = null;

        try {
            Open();
            Cursor cursor = db.query(
                    Travel.TABLE_NAME,
                    columns,
                    Travel.USERNAME_COLUMN + " = ?",
                    new String[]{username},
                    null,
                    null,
                    null
            );

            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                travels.add(CursorToStructure(cursor));
                break;
            }
        } catch (Error e) {

        } finally {
            Close();
        }

        return travels;
    }

    public final Travel CursorToStructure(Cursor cursor) {
        Travel model = new Travel();
        model.setDistance(cursor.getInt(0));
        model.setNumberOfPeople(cursor.getInt(1));
        model.setTotalCost(cursor.getFloat(2));
        model.setUsername(cursor.getString(3));
        return model;
    }
}

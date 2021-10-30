package com.example.wanderer.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.wanderer.database.DbOpenHelper;
import com.example.wanderer.database.model.TravelModel;

import java.util.ArrayList;
import java.util.List;

public class TravelDAO extends AbstractDAO {
    private final String[]
            columns = {
            TravelModel.DURATION_COLUMN,
            TravelModel.NUMBER_OF_PEOPLE_COLUMN,
            TravelModel.TOTAL_COST_COLUMN,
            TravelModel.USERNAME_COLUMN
    };

    public TravelDAO(final Context context) {
        db_helper = new DbOpenHelper(context);
    }

    public long Insert(TravelModel model) {
        long numberOfRows;

        try {
            Open();
            ContentValues values = new ContentValues();
            values.put(TravelModel.NUMBER_OF_PEOPLE_COLUMN, model.getNumberOfPeople());
            values.put(TravelModel.TOTAL_COST_COLUMN, model.getTotalCost());
            values.put(TravelModel.DURATION_COLUMN, model.getDuration());
            values.put(TravelModel.USERNAME_COLUMN, model.getUsername());

            numberOfRows = db.insert(TravelModel.TABLE_NAME, null, values);
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

    public ArrayList<TravelModel> Select(final String username) {
        ArrayList<TravelModel> travelModels = new ArrayList<>();

        try {
            Open();
            Cursor cursor = db.query(
                    TravelModel.TABLE_NAME,
                    columns,
                    TravelModel.USERNAME_COLUMN + " = ?",
                    new String[]{username},
                    null,
                    null,
                    null
            );
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                travelModels.add(CursorToStructure(cursor));
                break;
            }
        } catch (Error e) {

        } finally {
            Close();
        }

        return travelModels;
    }

    public final TravelModel CursorToStructure(Cursor cursor) {
        TravelModel model = new TravelModel();
        model.setDuration(cursor.getInt(0));
        model.setNumberOfPeople(cursor.getInt(1));
        model.setTotalCost(cursor.getFloat(2));
        model.setUsername(cursor.getString(3));
        return model;
    }
}

package com.example.wanderer.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.wanderer.database.DbOpenHelper;
import com.example.wanderer.database.model.User;

public class UsersDAO extends AbstractDAO {
    private final String[]
            columns = {
            User.EMAIL_COLUMN,
            User.USERNAME_COLUMN,
            User.PASSWORD_COLUMN,
    };

    public UsersDAO(final Context context) {
        db_helper = new DbOpenHelper(context);
    }

    public long insert(User model) {
        long numberOfRows;

        try {
            Open();
            ContentValues values = new ContentValues();
            values.put(User.EMAIL_COLUMN, model.getEmail());
            values.put(User.USERNAME_COLUMN, model.getUsername());
            values.put(User.PASSWORD_COLUMN, model.getPassword());
            numberOfRows = db.insert(User.TABLE_NAME, null, values);
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

    public User verifyLogin(final String username, final String password) {

        User model = null;
        try {
            Open();
            Cursor cursor = db.query(
                    User.TABLE_NAME,
                    columns,
                    User.USERNAME_COLUMN + " = ? and " + User.PASSWORD_COLUMN + " = ?",
                    new String[]{username, password},
                    null,
                    null,
                    null); //

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

    public User select(final String username) {
        User model = null;

        try {
            Open();
            Cursor cursor = db.query(
                    User.TABLE_NAME,
                    columns,
                    User.USERNAME_COLUMN + " = ?",
                    new String[]{username},
                    null,
                    null,
                    null);

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

    public final User CursorToStructure(Cursor cursor) {
        User model = new User();
        model.setEmail(cursor.getString(0));
        model.setPassword(cursor.getString(1));
        model.setUsername(cursor.getString(2));
        return model;
    }
}

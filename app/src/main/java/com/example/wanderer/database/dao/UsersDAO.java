package com.example.wanderer.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.wanderer.database.DbOpenHelper;
import com.example.wanderer.database.model.UserModel;

public class UsersDAO extends AbstractDAO {
    private final String[]
            columns = {
            UserModel.EMAIL_COLUMN,
            UserModel.USERNAME_COLUMN,
            UserModel.PASSWORD_COLUMN,
    };

    public UsersDAO(final Context context) {
        db_helper = new DbOpenHelper(context);
    }

    public long insert(UserModel model) {
        long numberOfRows;

        try {
            Open();
            ContentValues values = new ContentValues();
            values.put(UserModel.EMAIL_COLUMN, model.getEmail());
            values.put(UserModel.USERNAME_COLUMN, model.getUsername());
            values.put(UserModel.PASSWORD_COLUMN, model.getPassword());
            numberOfRows = db.insert(UserModel.TABLE_NAME, null, values);
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

    public UserModel verifyLogin(final String username, final String password) {

        UserModel model = null;
        try {
            Open();
            Cursor cursor = db.query(
                    UserModel.TABLE_NAME,
                    columns,
                    UserModel.USERNAME_COLUMN + " = ? and " + UserModel.PASSWORD_COLUMN + " = ?",
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

    public UserModel select(final String username) {
        UserModel model = null;

        try {
            Open();
            Cursor cursor = db.query(
                    UserModel.TABLE_NAME,
                    columns,
                    UserModel.USERNAME_COLUMN + " = ?",
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

    public final UserModel CursorToStructure(Cursor cursor) {
        UserModel model = new UserModel();
        model.setEmail(cursor.getString(0));
        model.setUsername(cursor.getString(1));
        model.setPassword(cursor.getString(2));
        return model;
    }
}

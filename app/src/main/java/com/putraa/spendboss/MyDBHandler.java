package com.putraa.spendboss;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;

/**
 * SpendBoss Android - MyDBHandler
 * This file enable other java file to manipulate local database.
 *
 * This code used to:
 * - create initial database
 * - access and apply changes to database (add/edit/remove)
 * - access and obtain data from database
 *
 * @author Adrian Pratama Putra
 * @version 0.1
 * @since 2017-01-23
 */

public class MyDBHandler extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "user_file.db";
    private static final int DATABASE_VERSION = 1;
    public static final String TABLE_USERS = "user_main";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_DAYSAFTER = "daysafter";
    public static final String COLUMN_HAND = "hand";
    public static final String COLUMN_BANK = "bank";
    public static final String COLUMN_SPENDING = "spending";
    public static final String COLUMN_ADDITIONAL = "additional";
    public static final String COLUMN_CUTTERS = "cutters";
    public static final String COLUMN_WORK = "work";
    public static final String COLUMN_SKIP = "skip";
    public static final String COLUMN_NOTES = "notes";

    public MyDBHandler(Context context) {
        /* Creates the database */
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /* Create Table */
        String query = "CREATE TABLE " + TABLE_USERS + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT ," +
                COLUMN_DATE + " DATE ," +
                COLUMN_DAYSAFTER + " INTEGER ," +
                COLUMN_HAND + " FLOAT ," +
                COLUMN_BANK + " FLOAT ," +
                COLUMN_SPENDING + " FLOAT ," +
                COLUMN_ADDITIONAL + " FLOAT ," +
                COLUMN_CUTTERS + " FLOAT ," +
                COLUMN_WORK + " FLOAT ," +
                COLUMN_SKIP + " BOOLEAN ," +
                COLUMN_NOTES + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //Add a new row to db
    public boolean addUserData(UserData userdata) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_DATE, String.valueOf(userdata.get_date()));
        values.put(COLUMN_DAYSAFTER, userdata.get_daysafter());
        values.put(COLUMN_HAND, userdata.get_hand());
        values.put(COLUMN_BANK, userdata.get_bank());
        values.put(COLUMN_SPENDING, userdata.get_spending());
        values.put(COLUMN_ADDITIONAL, userdata.get_additional());
        values.put(COLUMN_CUTTERS, userdata.get_cutters());
        values.put(COLUMN_WORK, userdata.get_work());
        values.put(COLUMN_SKIP, userdata.is_skip());
        values.put(COLUMN_NOTES, userdata.get_notes());

        long result = db.insert(TABLE_USERS, null, values);
        if (result == -1)
            return false;
        else
            return true;
    }

    //databaseToString new method
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_USERS,null);
        return res;
    }
}

package com.putraa.spendboss;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.Cursor;
import android.content.Context;
import android.content.ContentValues;
import android.util.Log;

import java.util.Date;

public class MyDBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "user_file.db";
    public static final String TABLE_USERS = "user_main";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_DATE = "_date";
    public static final String COLUMN_DAYSAFTER = "_daysafter";
    public static final String COLUMN_HAND = "_hand";
    public static final String COLUMN_BANK = "_bank";
    public static final String COLUMN_SPENDING = "_spending";
    public static final String COLUMN_ADDITIONAL = "_additional";
    public static final String COLUMN_CUTTERS = "_cutters";
    public static final String COLUMN_WORK = "_work";
    public static final String COLUMN_SKIP = "_skip";
    public static final String COLUMN_NOTES = "_notes";

    //Create Database
    public MyDBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    //Create Table
    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_USERS + "(" +
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
                COLUMN_NOTES + " VARCHAR(225) " +
                ");";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    //Add a new row to db
    public boolean addUserData(UserData userdata) {
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

        SQLiteDatabase db = getWritableDatabase();
        long result = db.insert(TABLE_USERS, null, values);
        if (result == -1)
            return false;
        else
            return true;
        // db.close();
    }

    //Delete a product from the database
    public void deleteData(Date date) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_USERS + " WHERE " + COLUMN_DATE + "=\"" + date + "\";");
    }

    //databaseToString new method
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_USERS,null);
        return res;
    }

    public String databaseToString() {
        StringBuilder dbString = new StringBuilder();
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_USERS;

        //Cursor point to a location in your results
        Cursor c = db.rawQuery(query, null);
        //Move to the first row in your results
        c.moveToFirst();

        while(!c.isAfterLast()) {
            dbString.append(c.getString(c.getColumnIndex("bank")));
//          dbString.append(c.getString(c.getColumnIndex("date")) + " | ");
//          dbString += c.getString(c.getColumnIndex("hand")) + " | ";
//          dbString += "\n";
            c.moveToNext();
        }
        Log.d("alongtag", dbString.toString());
        db.close();
        return dbString.toString();
    }
}

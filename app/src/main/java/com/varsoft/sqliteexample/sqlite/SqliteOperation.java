package com.varsoft.sqliteexample.sqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SqliteOperation {

    private Context context;
    private SQLiteDatabase sqLiteDatabase;
    public Cursor cursor;

    public SqliteOperation(Context context) {
        this.context = context;
        sqLiteDatabase = context.openOrCreateDatabase("Words", context.MODE_PRIVATE, null);


    }

    public void createTable() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS words (ID INTEGER PRIMARY KEY AUTOINCREMENT, TR VARCHAR, EN VARCHAR, INSERTDATE VARCHAR)");

    }

    public void insertTable(String tr, String en) {
//    public void insertTable() {
        String insertDate = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());
        sqLiteDatabase.execSQL("INSERT INTO words (TR, EN, INSERTDATE) VALUES(" + tr + "," + en + "," + insertDate + ")");
//        sqLiteDatabase.execSQL("INSERT INTO words (TR, EN, INSERTDATE) VALUES('sad','asda','asdsad')");
    }

    public void allData() {
        cursor = sqLiteDatabase.rawQuery("SELECT * FROM words",null);
        int idIx = cursor.getColumnIndex("ID");
        int trIx = cursor.getColumnIndex("TR");
        int enIx = cursor.getColumnIndex("EN");
        int dateIx = cursor.getColumnIndex("INSERTDATE");

        while (cursor.moveToNext()) {
            Log.e("ID", " " + cursor.getInt(idIx));
            Log.e("TR", " " + cursor.getString(trIx));
            Log.e("EN", " " + cursor.getString(enIx));
            Log.e("DATE", " " + cursor.getString(dateIx));
        }
    }

}

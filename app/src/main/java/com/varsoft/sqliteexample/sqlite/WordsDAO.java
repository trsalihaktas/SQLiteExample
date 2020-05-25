package com.varsoft.sqliteexample.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.varsoft.sqliteexample.model.Words;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class WordsDAO {

    public void addWord(DatabaseManager databaseManager, String tr, String en) {
        SQLiteDatabase sqLiteDatabase = databaseManager.getWritableDatabase();
        String insertdate = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());

        String sqlQuery = "INSERT INTO words (tr, en, insertdate, updatedate) VALUES ('"+tr+"', '"+en+"', '"+insertdate+"', '"+insertdate+"')";
        sqLiteDatabase.rawQuery(sqlQuery,null).moveToNext();

//        ContentValues contentValues = new ContentValues();
//        contentValues.put("tr", tr);
//        contentValues.put("en", en);
//        contentValues.put("insertdate", insertdate);
//        contentValues.put("updatedate", insertdate);
//        sqLiteDatabase.insertOrThrow("words", null, contentValues);
        sqLiteDatabase.close();
    }

    public ArrayList<Words> allData(DatabaseManager databaseManager) {
        ArrayList<Words> wordsArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = databaseManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM words", null);
        while (cursor.moveToNext()) {
            Words word = new Words(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("tr")),
                    cursor.getString(cursor.getColumnIndex("en")),
                    cursor.getString(cursor.getColumnIndex("insertdate")),
                    cursor.getString(cursor.getColumnIndex("updatedate")));

            wordsArrayList.add(word);
        }
        return wordsArrayList;
    }

    public ArrayList<Words> allDataFromDate(DatabaseManager databaseManager, String insertdate) {
        ArrayList<Words> wordsArrayList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = databaseManager.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM words WHERE insertdate = '"+insertdate+"'", null);
        while (cursor.moveToNext()) {
            Words word = new Words(cursor.getInt(cursor.getColumnIndex("id")),
                    cursor.getString(cursor.getColumnIndex("tr")),
                    cursor.getString(cursor.getColumnIndex("en")),
                    cursor.getString(cursor.getColumnIndex("insertdate")),
                    cursor.getString(cursor.getColumnIndex("updatedate")));

            wordsArrayList.add(word);
        }
        return wordsArrayList;
    }


    public void deleteData(DatabaseManager databaseManager, int id, String tr) {
        SQLiteDatabase sqLiteDatabase = databaseManager.getWritableDatabase();

        String sqlQuery = "DELETE FROM words WHERE id = " + id + " OR tr LIKE '%" + tr + "%'";
        sqLiteDatabase.rawQuery(sqlQuery, null).moveToFirst();

//        sqLiteDatabase.delete("words", "id=?", new String[]{String.valueOf(id)});

        sqLiteDatabase.close();
    }

    public void updateData(DatabaseManager databaseManager, int id, String tr, String en) {
        SQLiteDatabase sqLiteDatabase = databaseManager.getWritableDatabase();

        String updatedate = new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(new Date());


        String sqlQuery = "UPDATE words SET tr = '" + tr + "', en = '" + en + "', updatedate = '" + updatedate + "' WHERE id = " + id;

        sqLiteDatabase.rawQuery(sqlQuery, null).moveToNext();

//        ContentValues contentValues = new ContentValues();
//        contentValues.put("tr", tr);
//        contentValues.put("en", en);
//        contentValues.put("updatedate", updatedate);
//        sqLiteDatabase.update("words", contentValues, "id=?", new String[]{String.valueOf(id)});

        sqLiteDatabase.close();

    }

}

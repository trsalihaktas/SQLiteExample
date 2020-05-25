package com.varsoft.sqliteexample.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseManager extends SQLiteOpenHelper {

    public DatabaseManager(Context context) {
        super(context, "dictionary", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE words (id INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,tr TEXT, en TEXT, insertdate TEXT, updatedate TEXT  )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS words");
        onCreate(sqLiteDatabase);

    }

}

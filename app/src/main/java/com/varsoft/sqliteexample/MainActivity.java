package com.varsoft.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.varsoft.sqliteexample.model.Words;
import com.varsoft.sqliteexample.sqlite.DatabaseManager;
import com.varsoft.sqliteexample.sqlite.WordsDAO;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private DatabaseManager databaseManager;
    private WordsDAO wordsDAO;
    private ArrayList<Words> wordsArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        databaseManager = new DatabaseManager(this);
        wordsDAO = new WordsDAO();

        getsql();


        readDataFrom();


    }

    private void getsql() {
//        addDataFrom("köpek", "dog");
//        readDataFrom();
//        deleteDataFrom(0, "edi");
//        addDataFrom("kedi", "cat");
//        updateDataFrom(10, "kediate", "catupdate");
    }

    public void addDataFrom(String tr, String en) {
        wordsDAO.addWord(databaseManager, tr, en);
    }

    public void readDataFrom() {
        wordsArrayList = new WordsDAO().allData(databaseManager);
        for (Words words : wordsArrayList) {
            Log.e("" + words.getId(), "" + words.getTr() + " -> " + words.getEn() + "  *  " + words.getInsertdate() + " - " + words.getUpdatedate());
        }
    }

    public void updateDataFrom(int id, String tr, String en) {
        wordsDAO.updateData(databaseManager, id, tr, en);

    }

    public void deleteDataFrom(int id, String tr) {
        wordsDAO.deleteData(databaseManager, id, tr);
    }
}

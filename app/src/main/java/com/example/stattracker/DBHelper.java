package com.example.stattracker;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //Database name and version
    private static final String DATABASE_NAME = "statTracker.db";
    private static final int DATABASE_VERSION = 1;

    //Strings to create Tables
    private static String CREATE_USER_INFORMATION = "create table UserInformation (UserID INTEGER PRIMARY KEY AUTOINCREMENT, FName TEXT NOT NULL, LName TEXT NOT NULL, NumberOfTeams INTEGER NOT NULL)";
    private static String CREATE_SPORTS_TEAMS = "create table SportsTeams (TeamID INTEGER PRIMARY KEY AUTOINCREMENT, TeamName TEXT NOT NULL, Wins INTEGER, Losses INTEGER, NumberOfTeams INTEGER NOT NULL, Sport INTEGER NOT NULL)";
    private static String TEST_USER_DATA = "INSERT INTO UserInformation (FName, LName, NumberOfTeams) VALUES (Derek, Johnson, 12)";

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER_INFORMATION);
        db.execSQL(CREATE_SPORTS_TEAMS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

}

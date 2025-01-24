package com.example.stattracker;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    //Database name and version
    private static final String DATABASE_NAME = "statTracker.db";
    private static final int DATABASE_VERSION = 1;

    //Strings to create Tables
    private static String USER_INFORMATION = "create table UserInformation (UserID INTEGER PRIMARY KEY AUTOINCREMENT, FName TEXT NOT NULL, LName TEXT NOT NULL, BDay DATE NOT NULL , NumberOfTeams INTEGER, NumberOfTeams INTEGER)";
    private static String SPORTS_TEAMS = "create table SportsTeams (TeamID INTEGER PRIMARY KEY AUTOINCREMENT, TeamName TEXT NOT NULL, NumberOfPlayers INTEGER , Wins INTEGER, Losses INTEGER, GamesPlayed INTEGER, Sport TEXT)";
    private static String TEAM_MATES = "create table Teammates (RosterID INTEGER PRIMARY KEY, FName TEXT NOT NULL, LName TEXT NOT NULL, Position TEXT, Captain BOOLEAN ,Overall_Scores INTEGER, Overall_Assists INTEGER, Overall_Blocks INTEGER)";

    //Variables used to insert, edit, and delete data from the tables
    SQLiteDatabase db = this.getWritableDatabase();
    ContentValues cv = new ContentValues();

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_INFORMATION);
        db.execSQL(SPORTS_TEAMS);
        db.execSQL(TEAM_MATES);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

    }

    //Used when tha app is open for the first time or no database is saved
    private boolean InsertNewUser(String first, String last, String date) {
        cv.put("FName", first);
        cv.put("LName", last);
        cv.put("BDay", date);
        cv.put("NumberOfTeams", 0);
        cv.put("NumberOfGames", 0);
        long result = db.insert("UserInformation", null, cv);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }


    //This will be used to create only new people onto a team
    private boolean InsertNewTeammate(int id, String firstName, String lastName, String position, boolean Captain) {
        cv.put("RosterID", id);
        cv.put("FName", firstName);
        cv.put("LName", lastName);
        cv.put("Position", position);
        cv.put("Captain", Captain);
        cv.put("Overall_Scores", 0);
        cv.put("Overall_Assists", 0);
        cv.put("Overall_Blocks", 0);
        cv.put("Overall_Score_Ratio", 0);
        long result = db.insert("Teammates", null, cv);
        if (result == -1) {
            return false;
        }
        else {
            return true;
        }
    }



}

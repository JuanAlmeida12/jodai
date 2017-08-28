package com.example.admin.myapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.admin.myapplication.models.Mission;
import com.example.admin.myapplication.models.Task;

/**
 * Created by Admin on 16/08/2017.
 */

public class RiddleChaseDBHelper extends SQLiteOpenHelper {

    private static final String TEXT_TYPE = " TEXT";
    private static final String INT_TYPE = " INTEGER";
    private static final String FLOAT_TYPE = " REAL";
    private static final String COMMA_SEP = ",";

    // SQL TO CREATE TABLES
    private static final String SQL_CREATE_MISSION =
            "CREATE TABLE  MISSION(" +
                    "mission_id" + " INTEGER PRIMARY KEY," +
                    "mission_name" + TEXT_TYPE + COMMA_SEP +
                    "mission_description" + TEXT_TYPE + COMMA_SEP +
                    "progress" + FLOAT_TYPE + " )";

    private static final String SQL_DELETE_MISSION =
            "DROP TABLE IF EXISTS MISSION";

    private static final String SQL_CREATE_TASK =
            "CREATE TABLE  TASK(" +
                    "task_id" + " INTEGER PRIMARY KEY," +
                    "mission_id" + INT_TYPE + COMMA_SEP +
                    "task_name" + TEXT_TYPE + COMMA_SEP +
                    "task_question" + TEXT_TYPE + COMMA_SEP +
                    "next_tip" + TEXT_TYPE + COMMA_SEP +
                    "task_answer" + TEXT_TYPE + COMMA_SEP +
                    "facts_task" + TEXT_TYPE + COMMA_SEP +
                    "task_lat" + FLOAT_TYPE + COMMA_SEP +
                    "task_lng" + FLOAT_TYPE + COMMA_SEP +
                    "task_number" + INT_TYPE + COMMA_SEP +
                    "done" + INT_TYPE + " )";

    private static final String SQL_DELETE_TASK =
            "DROP TABLE IF EXISTS TASK";

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "RiddleChase.db";

    public RiddleChaseDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_MISSION);
        db.execSQL(SQL_CREATE_TASK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_MISSION);
        db.execSQL(SQL_DELETE_TASK);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}

package com.example.admin.myapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.admin.myapplication.models.*;
import com.example.admin.myapplication.models.Mission;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 16/08/2017.
 */

public class DatabaseManager {

    public static List<Task> getTasks(int mission_id, Context ctx) {
        RiddleChaseDBHelper mDbHelper = new RiddleChaseDBHelper(ctx);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                "task_id",
                "mission_id",
                "task_name",
                "task_question",
                "next_tip",
                "task_answer",
                "facts_task",
                "task_lat",
                "task_lng",
                "task_number",
                "done"
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = "mission_id = ?";
        String[] selectionArgs = {mission_id + ""};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                "task_id DESC";

        Cursor c = db.query(
                "TASK",                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );

        List<Task> tasks = new ArrayList<>();

        c.moveToFirst();

        while (!c.isAfterLast()) {
            int task_id = c.getInt(c.getColumnIndexOrThrow("task_id"));
            int mission_id2 = c.getInt(c.getColumnIndexOrThrow("mission_id"));
            int task_number = c.getInt(c.getColumnIndexOrThrow("task_number"));
            String task_name = c.getString(c.getColumnIndexOrThrow("task_name"));
            String task_question = c.getString(c.getColumnIndexOrThrow("task_question"));
            String facts_task = c.getString(c.getColumnIndexOrThrow("facts_task"));
            String next_tip = c.getString(c.getColumnIndexOrThrow("next_tip"));
            String task_answer = c.getString(c.getColumnIndexOrThrow("task_answer"));
            float task_lat = c.getFloat(c.getColumnIndexOrThrow("task_lat"));
            float task_lng = c.getFloat(c.getColumnIndexOrThrow("task_lng"));
            boolean done = c.getInt(c.getColumnIndexOrThrow("done")) == 1 ? true : false;

            Log.e("aaaaaaaaaaaaaa", next_tip);

            tasks.add(new Task(task_id, mission_id2, task_name, task_question, task_answer, task_lat, task_lng, done, task_number, facts_task, next_tip));
            c.moveToNext();
        }

        return tasks;
    }

    public static void addMission(Mission mission, Context ctx) {
        RiddleChaseDBHelper mDbHelper = new RiddleChaseDBHelper(ctx);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("mission_id", mission.getMission_id());
        values.put("mission_name", mission.getMission_name());
        values.put("mission_description", mission.getMission_description());
        values.put("progress", mission.getProgress());

        // Insert the new row, returning the primary key value of the new row
        db.insert("MISSION", null, values);
    }

    public static void addTask(Task task, Context ctx) {
        RiddleChaseDBHelper mDbHelper = new RiddleChaseDBHelper(ctx);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("task_id", task.getTask_id());
        values.put("mission_id", task.getMission_id());
        values.put("task_name", task.getTask_name());
        values.put("task_question", task.getTask_question());
        values.put("task_answer", task.getTask_answer());
        values.put("task_lat", task.getTask_lat());
        values.put("task_lng", task.getTask_lng());
        values.put("task_number", task.getTask_number());
        values.put("next_tip", task.getNext_tip());
        values.put("facts_task", task.getFacts_task());
        values.put("done", task.isDone() ? 1 : 0);

        // Insert the new row, returning the primary key value of the new row
        db.insert("TASK", null, values);
    }

    public static List<Mission> getMissions(Context ctx) {
        RiddleChaseDBHelper mDbHelper = new RiddleChaseDBHelper(ctx);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                "mission_id",
                "mission_name",
                "mission_description",
                "progress"
        };

        Cursor c = db.query(
                "MISSION",                     // The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        List<Mission> missions = new ArrayList<>();

        c.moveToFirst();

        while (!c.isAfterLast()) {
            int mission_id = c.getInt(c.getColumnIndexOrThrow("mission_id"));
            float progress = c.getFloat(c.getColumnIndexOrThrow("progress"));
            String mission_description = c.getString(c.getColumnIndexOrThrow("mission_description"));
            String mission_name = c.getString(c.getColumnIndexOrThrow("mission_name"));

            missions.add(new Mission(mission_id, mission_name, mission_description, progress));
            c.moveToNext();
        }

        return missions;
    }

    public static void updateTask(Task task, Context ctx) {
        RiddleChaseDBHelper mDbHelper = new RiddleChaseDBHelper(ctx);
        // Gets the data repository in write mode
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put("task_name", task.getTask_name());
        values.put("task_question", task.getTask_question());
        values.put("task_answer", task.getTask_answer());
        values.put("task_lat", task.getTask_lat());
        values.put("task_lng", task.getTask_lng());
        values.put("done", task.isDone() ? 1 : 0);

        String selection = "task_id = ?";
        String[] selectionArgs = {task.getTask_id() + ""};


        // Insert the new row, returning the primary key value of the new row
        db.update(
                "TASK",
                values,
                selection,
                selectionArgs);
    }

}

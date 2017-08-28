package com.example.admin.myapplication.models;

/**
 * Created by Admin on 16/08/2017.
 */

public class Task {

    private int task_id;
    private int mission_id;
    private String task_name;
    private String task_question;
    private String task_answer;
    private float task_lat;
    private float task_lng;
    private boolean done;
    private int task_number;
    private String facts_task;
    private String next_tip;

    public Task(int task_id, int mission_id, String task_name, String task_question, String task_answer, float task_lat, float task_lng, boolean done, int task_number, String facts_task, String next_tip) {
        this.task_id = task_id;
        this.mission_id = mission_id;
        this.task_name = task_name;
        this.task_question = task_question;
        this.task_answer = task_answer;
        this.task_lat = task_lat;
        this.task_lng = task_lng;
        this.done = done;
        this.task_number = task_number;
        this.facts_task = facts_task;
        this.next_tip = next_tip;
    }

    public int getTask_id() {
        return task_id;
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public int getMission_id() {
        return mission_id;
    }

    public void setMission_id(int mission_id) {
        this.mission_id = mission_id;
    }

    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }

    public String getTask_question() {
        return task_question;
    }

    public void setTask_question(String task_question) {
        this.task_question = task_question;
    }

    public String getTask_answer() {
        return task_answer;
    }

    public void setTask_answer(String task_answer) {
        this.task_answer = task_answer;
    }

    public float getTask_lat() {
        return task_lat;
    }

    public void setTask_lat(float task_lat) {
        this.task_lat = task_lat;
    }

    public float getTask_lng() {
        return task_lng;
    }

    public void setTask_lng(float task_lng) {
        this.task_lng = task_lng;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public int getTask_number() {
        return task_number;
    }

    public void setTask_number(int task_number) {
        this.task_number = task_number;
    }

    public String getFacts_task() {
        return facts_task;
    }

    public void setFacts_task(String facts_task) {
        this.facts_task = facts_task;
    }

    public String getNext_tip() {
        return next_tip;
    }

    public void setNext_tip(String next_tip) {
        this.next_tip = next_tip;
    }
}

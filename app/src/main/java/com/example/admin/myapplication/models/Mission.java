package com.example.admin.myapplication.models;

import java.util.List;

/**
 * Created by Admin on 16/08/2017.
 */

public class Mission {

    private int mission_id;
    private String mission_name;
    private String mission_description;
    private float progress;

    public Mission(){}

    public Mission(int mission_id, String mission_name, String mission_description, float progress) {
        this.mission_id = mission_id;
        this.mission_name = mission_name;
        this.mission_description = mission_description;
        this.progress = progress;
    }

    public int getMission_id() {
        return mission_id;
    }

    public void setMission_id(int mission_id) {
        this.mission_id = mission_id;
    }

    public String getMission_name() {
        return mission_name;
    }

    public void setMission_name(String mission_name) {
        this.mission_name = mission_name;
    }

    public String getMission_description() {
        return mission_description;
    }

    public void setMission_description(String mission_description) {
        this.mission_description = mission_description;
    }

    public float getProgress() {
        return progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
    }

}

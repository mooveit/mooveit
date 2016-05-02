package com.ideyatech.moove.sql.beans;

import java.sql.Date;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class Calories extends DashboardItems {

    public int id;
    public int noOfCalories;
    public Date timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfCalories() {
        return noOfCalories;
    }

    public void setNoOfCalories(int noOfCalories) {
        this.noOfCalories = noOfCalories;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

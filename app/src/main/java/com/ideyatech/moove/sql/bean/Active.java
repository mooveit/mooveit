package com.ideyatech.moove.sql.bean;

import java.sql.Date;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class Active extends DashboardItems {

    public int id;
    public int noOfActive;
    public Date timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfActive() {
        return noOfActive;
    }

    public void setNoOfActive(int noOfActive) {
        this.noOfActive = noOfActive;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

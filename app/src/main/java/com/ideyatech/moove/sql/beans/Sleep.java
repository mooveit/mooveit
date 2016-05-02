package com.ideyatech.moove.sql.beans;

import java.sql.Date;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class Sleep extends DashboardItems {

    public int id;
    public int noOfSleep;
    public Date timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfSleep() {
        return noOfSleep;
    }

    public void setNoOfSleep(int noOfSleep) {
        this.noOfSleep = noOfSleep;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

package com.ideyatech.moove.sql.bean;

import java.sql.Date;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class Moves extends DashboardItems {

    public int id;
    public int noOfMoves;
    public Date timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNoOfMoves() {
        return noOfMoves;
    }

    public void setNoOfMoves(int noOfMoves) {
        this.noOfMoves = noOfMoves;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}

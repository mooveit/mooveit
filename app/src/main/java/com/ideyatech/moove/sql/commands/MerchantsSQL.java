package com.ideyatech.moove.sql.commands;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class MerchantsSQL {

    public static final String TABLE_NAME = "merchants";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MAPSID = "mapsid";
    public static final String COLUMN_LOGOID = "logoid";
    public static final String COLUMN_WEBSITE = "website";

    public static final String DATABASE_CREATE_MERCHANT = "create table "

            + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null,  "
            + COLUMN_MAPSID + " text not null,  "
            + COLUMN_LOGOID + " text not null "
            + ");";

}

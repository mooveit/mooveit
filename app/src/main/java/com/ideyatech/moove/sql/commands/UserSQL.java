package com.ideyatech.moove.sql.commands;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class UserSQL {

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";


    public static final String DATABASE_CREATE_SLEEP= "create table "
            + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_USERNAME + " text not null,"
            + COLUMN_PASSWORD + " text not null "
            + ");";
}

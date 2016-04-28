package com.ideyatech.moove.sql.commands;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class UserSQL {

    public static final String TABLE_NAME = "user";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_USERNAME = "username";
    public static final String COLUMN_PASSWORD = "password";
    public static final String COLUMN_AGE = "age";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_WEIGHT = "weight";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_FULLNAME = "fullname";
    public static final String COLUMN_BIRTHDAY = "birthday";


    public static final String DATABASE_CREATE_SLEEP= "create table "
            + TABLE_NAME + "("
            + COLUMN_ID         + " integer primary key autoincrement, "
            + COLUMN_USERNAME   + " text not null,"
            + COLUMN_PASSWORD   + " text not null, "
            + COLUMN_AGE        + " integer, "
            + COLUMN_GENDER     + " integer, "
            + COLUMN_WEIGHT     + " integer, "
            + COLUMN_HEIGHT     + " integer, "
            + COLUMN_FULLNAME   + " text not null, "
            + COLUMN_BIRTHDAY   + " text not null "
            + ");";
}

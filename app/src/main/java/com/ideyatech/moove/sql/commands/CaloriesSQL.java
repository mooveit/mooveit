package com.ideyatech.moove.sql.commands;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class CaloriesSQL {

    public static final String TABLE_NAME = "calories";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_CALORIES = "noofcalories";
    public static final String COLUMN_TIMESTAMP = "timestamp";

    public static final String DATABASE_CREATE_CALORIES = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID + " integer primary key autoincrement, "
            + COLUMN_CALORIES + " text not null,  "
            + COLUMN_TIMESTAMP + " datetime"
            + ");";

}

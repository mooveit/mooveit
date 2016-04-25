package com.ideyatech.moove.sql.commands;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class RewardsSQL {

    public static final String TABLE_NAME = "rewards";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MERCHANT = "merchant";
    public static final String COLUMN_IMAGEID = "imageid";
    public static final String COLUMN_CLAIMED = "claimed";
    public static final String COLUMN_REWARDFLAG = "rewardflag";
    public static final String COLUMN_MECHANICS = "mechanics";
    public static final String COLUMN_TARGETCALORIES = "targetcalories";
    public static final String COLUMN_TARGETSLEEP = "targetsleep";
    public static final String COLUMN_TARGETMOVE = "targetmove";
    public static final String COLUMN_TARGETACTIVE = "targetactive";
    public static final String COLUMN_PROMOSTART = "promostart";
    public static final String COLUMN_PROMOEND= "promoend";

    public static final String DATABASE_CREATE_REWARDS = "create table "
            + TABLE_NAME + "("
            + COLUMN_ID  + " integer primary key autoincrement, "
            + COLUMN_NAME + " text not null, "
            + COLUMN_MERCHANT  + " text not null, "
            + COLUMN_IMAGEID + " text not null,  "
            + COLUMN_CLAIMED +  " int "
            + COLUMN_REWARDFLAG + " int, "
            + COLUMN_MECHANICS + " text not null, "
            + COLUMN_TARGETCALORIES + " int, "
            + COLUMN_TARGETSLEEP + " int, "
            + COLUMN_TARGETMOVE +  " int, "
            + COLUMN_TARGETACTIVE + " int, "
            + COLUMN_PROMOSTART + " datetime, "
            + COLUMN_PROMOEND + " datetime "
            + ");";

}

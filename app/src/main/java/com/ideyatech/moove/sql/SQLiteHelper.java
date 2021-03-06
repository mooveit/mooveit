package com.ideyatech.moove.sql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.ideyatech.moove.sql.beans.User;
import com.ideyatech.moove.sql.commands.ActiveSQL;
import com.ideyatech.moove.sql.commands.CaloriesSQL;
import com.ideyatech.moove.sql.commands.MerchantsSQL;
import com.ideyatech.moove.sql.commands.MovesSQL;
import com.ideyatech.moove.sql.commands.RewardsSQL;
import com.ideyatech.moove.sql.commands.SleepSQL;
import com.ideyatech.moove.sql.commands.UserSQL;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class SQLiteHelper extends SQLiteOpenHelper {


    public static final String TABLE_COMMENTS = "comments";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_COMMENT = "comment";

    private static final String DATABASE_NAME = "moove.db";
    private static final int DATABASE_VERSION = 1;

    // Database creation sql statement
    private static final String DATABASE_CREATE_COMMENTS = "create table "
            + TABLE_COMMENTS + "(" + COLUMN_ID
            + " integer primary key autoincrement, " + COLUMN_COMMENT
            + " text not null);";

    // Database creation sql statement
    SQLiteDatabase database;

    /**
     *
     * @param context
     */
    public SQLiteHelper(Context context) {
        //*****************************************************************************
        //*                               CREATE DATABASE
        //*****************************************************************************
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     *
     * @param database
     */
    @Override
    public void onCreate(SQLiteDatabase database) {

        Log.w(SQLiteHelper.class.getName()," CREATING TABLES");

        //*****************************************************************************
        //*                               CREATE TABLES
        //*****************************************************************************
        database.execSQL(ActiveSQL.DATABASE_CREATE_ACTIVE);
        Log.w(SQLiteHelper.class.getName(), " CREATING CALORIES TABLE");
        database.execSQL(CaloriesSQL.DATABASE_CREATE_CALORIES);
        Log.w(SQLiteHelper.class.getName(), " CREATING MERCHANT TABLE");
        database.execSQL(MerchantsSQL.DATABASE_CREATE_MERCHANT);
        Log.w(SQLiteHelper.class.getName(), " CREATING MOVES TABLE");
        database.execSQL(MovesSQL.DATABASE_CREATE_MOVES);
        Log.w(SQLiteHelper.class.getName(), " CREATING REWARDS TABLE");
        database.execSQL(RewardsSQL.DATABASE_CREATE_REWARDS);
        Log.w(SQLiteHelper.class.getName(), " CREATING SLEEP TABLE");
        database.execSQL(UserSQL.DATABASE_CREATE_SLEEP);
        Log.w(SQLiteHelper.class.getName(), " CREATING USER TABLE");


    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.w(SQLiteHelper.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + ActiveSQL.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + CaloriesSQL.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MerchantsSQL.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + MovesSQL.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RewardsSQL.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + SleepSQL.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + UserSQL.TABLE_NAME);

        onCreate(db);
    }

    /**
     *
     * @param username
     * @param password
     * @return
     */
    public String validateUsernameAndPassword(String username, String password){

        String fullname = "EMPTY";
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(UserSQL.TABLE_NAME,                                            // TABLE NAME
                 new String[]{UserSQL.COLUMN_FULLNAME},                                         // FULLNAME TO BE RETURNED
                 UserSQL.COLUMN_USERNAME + " = ? AND " + UserSQL.COLUMN_PASSWORD + " = ?",      // WHERE USERNAME AND PASSWORD
                 new String[]{username, password}, null, null, null );                          // WHERE VALUES

        cursor.moveToFirst();

        // GET FULLNAME
        if (cursor.moveToFirst()){
            do{
                fullname = cursor.getString(cursor.getColumnIndex(UserSQL.COLUMN_FULLNAME));
                // do what ever you want here
            }while(cursor.moveToNext());
        }

        return fullname;
    }

}

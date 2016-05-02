package com.ideyatech.moove.sql.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.sql.beans.User;
import com.ideyatech.moove.sql.commands.UserSQL;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class UserDAO {

    // Database fields
    private SQLiteDatabase database;
    private String[] allColumns = {
            UserSQL.COLUMN_ID,
            UserSQL.COLUMN_USERNAME,
            UserSQL.COLUMN_PASSWORD,
            UserSQL.COLUMN_AGE,
            UserSQL.COLUMN_GENDER,
            UserSQL.COLUMN_FULLNAME,
            UserSQL.COLUMN_HEIGHT,
            UserSQL.COLUMN_WEIGHT,
            UserSQL.COLUMN_BIRTHDAY};


    /**
     *
     * @param data
     */
    public void insertData(User data){

        User user = (User)data;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
        values.put(UserSQL.COLUMN_USERNAME, user.getUsername());
        values.put(UserSQL.COLUMN_PASSWORD, user.getPassword());
        values.put(UserSQL.COLUMN_AGE, user.getAge());
        values.put(UserSQL.COLUMN_BIRTHDAY, user.getBirthday());
        values.put(UserSQL.COLUMN_FULLNAME, user.getFullname());
        values.put(UserSQL.COLUMN_GENDER, user.getGender());
        values.put(UserSQL.COLUMN_WEIGHT, user.getWeight());
        values.put(UserSQL.COLUMN_HEIGHT, user.getHeight());


        // INSERT VALUES TO TABLE
        long insertId = database.insert(UserSQL.TABLE_NAME, null, values);

    }

    /**
     *
     * @param data
     */
    public void getData(User data){

    }

    /**
     *
     * @param
     */
    public String validateUsernameAndPassword(String username, String password){

        String fullname = null;

//        Cursor cursor = database.query(UserSQL.TABLE_NAME,                                     // TABLE NAME
//                new String[]{UserSQL.COLUMN_FULLNAME},                                         // FULLNAME TO BE RETURNED
//                UserSQL.COLUMN_USERNAME + "=?" + " and " + UserSQL.COLUMN_PASSWORD + "=?",     // WHERE USERNAME AND PASSWORD
//                new String[]{username, password},                                              // WHERE VALUES
//                null, null, null);

        Cursor cursor =   database.rawQuery("SELECT fullname FROM user WHERE username = 'king' and password = 'king';", null);

        try {
            fullname = cursor.getString(cursor.getColumnIndexOrThrow(UserSQL.COLUMN_FULLNAME));
        }
        catch(Exception e){
            fullname = null;

        }
        finally{
            return fullname;
        }
    }
}
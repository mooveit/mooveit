package com.ideyatech.moove.sql.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.bean.Active;
import com.ideyatech.moove.sql.bean.DashboardItems;
import com.ideyatech.moove.sql.commands.ActiveSQL;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class ActiveDataSource implements DashboardDataSource{



    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            ActiveSQL.COLUMN_ID,
            ActiveSQL.COLUMN_ACTIVE,
            ActiveSQL.COLUMN_TIMESTAMP };

    /**
     *
     * @param context
     */
    public ActiveDataSource(Context context) {

        dbHelper = new SQLiteHelper(context);
    }


    /**
     *
     * @param dashboardItems
     */
    @Override
    public void insertData(DashboardItems dashboardItems){

        Active active = (Active)dashboardItems;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
        values.put(ActiveSQL.COLUMN_ACTIVE, active.getNoOfActive());
        values.put(ActiveSQL.COLUMN_TIMESTAMP, active.getTimestamp().toString());

        // INSERT VALUES TO TABLE
        long insertId = database.insert(ActiveSQL.TABLE_NAME, null, values);

    }


    /**
     *
     * @param dateToday
     */
    public ArrayList<Integer> getDataPerHour(Date dateToday) {

        /**
         * Note get 24 hours in Day
         */
        return new ArrayList<>();
    }

    /**
     *
     * @param dateToday
     */
    public ArrayList<Integer> getDataPerDay(Date dateToday) {

        /**
         * Note get 30 days in Month
         */

        return new ArrayList<Integer>();
    }


    /**
     *
     * @param
     */
    public ArrayList<Integer> getDataPerMonth(Date dateToday) {

        return new ArrayList<Integer>();
    }

    /**
     *
     * @param
     */
    public ArrayList<Integer> getDataPerYear(Date dateToday) {

        return new ArrayList<Integer>();
    }



}

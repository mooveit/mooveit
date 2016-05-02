package com.ideyatech.moove.sql.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.beans.DashboardItems;
import com.ideyatech.moove.sql.beans.Sleep;
import com.ideyatech.moove.sql.commands.SleepSQL;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class SleepDAO implements DashboardDAO {

    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            SleepSQL.COLUMN_ID,
            SleepSQL.COLUMN_SLEEP,
            SleepSQL.COLUMN_TIMESTAMP};

    /**
     * @param context
     */
    public SleepDAO(Context context) {

        dbHelper = new SQLiteHelper(context);
    }

    /**
     * @throws SQLException
     */
    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    /**
     *
     */
    public void close() {
        dbHelper.close();
    }

    /**
     * @param dashboardItems
     */
    @Override
    public void insertData(DashboardItems dashboardItems) {

        Sleep data = (Sleep) dashboardItems;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
        values.put(SleepSQL.COLUMN_SLEEP, data.getNoOfSleep());
        values.put(SleepSQL.COLUMN_TIMESTAMP, data.getTimestamp().toString());

        // INSERT VALUES TO TABLE
        long insertId = database.insert(SleepSQL.TABLE_NAME, null, values);

    }


    /**
     * @param dateToday
     */
    public ArrayList<Integer> getDataPerHour(Date dateToday) {

        /**
         * Note get 24 hours in Day
         */
        return new ArrayList<>();
    }

    /**
     * @param dateToday
     */
    public ArrayList<Integer> getDataPerDay(Date dateToday) {

        /**
         * Note get 30 days in Month
         */

        return new ArrayList<Integer>();
    }


    /**
     * @param
     */
    public ArrayList<Integer> getDataPerMonth(Date dateToday) {

        return new ArrayList<Integer>();
    }

    /**
     * @param
     */
    public ArrayList<Integer> getDataPerYear(Date dateToday) {

        return new ArrayList<Integer>();
    }
}
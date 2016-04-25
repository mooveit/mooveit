package com.ideyatech.moove.sql.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.bean.Active;
import com.ideyatech.moove.sql.bean.Calories;
import com.ideyatech.moove.sql.bean.DashboardItems;
import com.ideyatech.moove.sql.commands.ActiveSQL;
import com.ideyatech.moove.sql.commands.CaloriesSQL;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class CaloriesDataSource implements DashboardDataSource{


    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            CaloriesSQL.COLUMN_ID,
            CaloriesSQL.COLUMN_CALORIES,
            CaloriesSQL.COLUMN_TIMESTAMP };

    /**
     *
     * @param context
     */
    public CaloriesDataSource(Context context) {

        dbHelper = new SQLiteHelper(context);
    }

    /**
     *
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
     *
     * @param dashboardItems
     */
    @Override
    public void insertData(DashboardItems dashboardItems){

        Calories data = (Calories)dashboardItems;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
        values.put(CaloriesSQL.COLUMN_CALORIES, data.getNoOfCalories());
        values.put(CaloriesSQL.COLUMN_TIMESTAMP, data.getTimestamp().toString());

        // INSERT VALUES TO TABLE
        long insertId = database.insert(CaloriesSQL.TABLE_NAME, null, values);

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

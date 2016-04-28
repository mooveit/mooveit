package com.ideyatech.moove.sql.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.bean.DashboardItems;
import com.ideyatech.moove.sql.bean.Moves;
import com.ideyatech.moove.sql.commands.CaloriesSQL;
import com.ideyatech.moove.sql.commands.MovesSQL;

import java.util.ArrayList;
import java.sql.Date;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class MovesDataSource implements DashboardDataSource{


    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            MovesSQL.COLUMN_ID,
            MovesSQL.COLUMN_MOVES,
            MovesSQL.COLUMN_TIMESTAMP };

    /**
     *
     * @param context
     */
    public MovesDataSource(Context context) {

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

        Moves data = (Moves)dashboardItems;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
        values.put(MovesSQL.COLUMN_MOVES, data.getNoOfMoves());
        values.put(MovesSQL.COLUMN_TIMESTAMP, data.getTimestamp().toString());

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

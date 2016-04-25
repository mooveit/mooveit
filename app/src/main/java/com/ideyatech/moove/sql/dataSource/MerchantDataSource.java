package com.ideyatech.moove.sql.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.sql.bean.Merchant;
import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.bean.Active;
import com.ideyatech.moove.sql.bean.DashboardItems;
import com.ideyatech.moove.sql.commands.ActiveSQL;
import com.ideyatech.moove.sql.commands.MerchantsSQL;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class MerchantDataSource {


    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            MerchantsSQL.COLUMN_ID,
            MerchantsSQL.COLUMN_NAME,
            MerchantsSQL.COLUMN_LOGOID,
            MerchantsSQL.COLUMN_MAPSID,
            MerchantsSQL.COLUMN_WEBSITE};

    /**
     *
     * @param context
     */
    public MerchantDataSource(Context context) {

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
     * @param data
     */
    public void insertData(Merchant data){

        Merchant merchant = (Merchant)data;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
        values.put(MerchantsSQL.COLUMN_LOGOID, merchant.getLogoId());
        values.put(MerchantsSQL.COLUMN_NAME, merchant.getName());
        values.put(MerchantsSQL.COLUMN_WEBSITE, merchant.getWebsite());
        values.put(MerchantsSQL.COLUMN_MAPSID, merchant.getMapsId());

        // INSERT VALUES TO TABLE
        long insertId = database.insert(MerchantsSQL.TABLE_NAME, null, values);

    }

    /**
     *
     * @param data
     */
    public void getData(Merchant data){

    }
}

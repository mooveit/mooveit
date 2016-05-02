package com.ideyatech.moove.sql.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.R;
import com.ideyatech.moove.sql.beans.Merchant;
import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.commands.MerchantsSQL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class MerchantDAO {


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
    public MerchantDAO(Context context) {

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
//        values.put(MerchantsSQL.COLUMN_LOGOID, merchant.getLogoId());
//        values.put(MerchantsSQL.COLUMN_NAME, merchant.getName());
//        values.put(MerchantsSQL.COLUMN_WEBSITE, merchant.getWebsite());
//        values.put(MerchantsSQL.COLUMN_MAPSID, merchant.getMapsId());

        String[] name = new String[] {"Toby's Sports", "Adidas Philippines", "Healthy Options", "Gold's Gym Philippines"};
        Integer[] logoId = new Integer[] {R.drawable.tobylogo, R.drawable.adidaslogo, R.drawable.healthylogo, R.drawable.goldlogo};
        String[] website = new String[] {"http://www.tobys.com", "http://shop.adidas.com.ph", "http://www.healthyoptions.com.ph", "http://www.goldsgym.com.ph"};

        for (int i = 0; i < 4; i++) {
            values.put(MerchantsSQL.COLUMN_LOGOID, logoId[i]);
            values.put(MerchantsSQL.COLUMN_NAME, name[i]);
            values.put(MerchantsSQL.COLUMN_WEBSITE, website[i]);
        }

        // INSERT VALUES TO TABLE
        long insertId = database.insert(MerchantsSQL.TABLE_NAME, null, values);

    }

    /**
     *
     * @param data
     */
    public List getData(Merchant data){

        String[] name = new String[] {"Toby's Sports", "Adidas Philippines", "Healthy Options", "Gold's Gym Philippines"};
        Integer[] logoId = new Integer[] {R.drawable.tobylogo, R.drawable.adidaslogo, R.drawable.healthylogo, R.drawable.goldlogo};
        String[] website = new String[] {"http://www.tobys.com", "http://shop.adidas.com.ph", "http://www.healthyoptions.com.ph", "http://www.goldsgym.com.ph"};

        List<com.ideyatech.moove.ui.beans.Merchant> lmer = new ArrayList<com.ideyatech.moove.ui.beans.Merchant>();
        for (int i = 0; i < 4; i++){
            com.ideyatech.moove.ui.beans.Merchant mer = new com.ideyatech.moove.ui.beans.Merchant(logoId[i], name[i], website[i]);
            lmer.add(mer);
        }

        return lmer;
    }
}

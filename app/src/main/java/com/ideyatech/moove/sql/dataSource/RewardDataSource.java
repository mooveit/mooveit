package com.ideyatech.moove.sql.dataSource;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.sql.bean.Reward;
import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.bean.Merchant;
import com.ideyatech.moove.sql.commands.MerchantsSQL;
import com.ideyatech.moove.sql.commands.RewardsSQL;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class RewardDataSource {



    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            RewardsSQL.COLUMN_ID,
            RewardsSQL.COLUMN_NAME,
            RewardsSQL.COLUMN_CLAIMED,
            RewardsSQL.COLUMN_REWARDFLAG,
            RewardsSQL.COLUMN_MECHANICS,
            RewardsSQL.COLUMN_TARGETSLEEP,
            RewardsSQL.COLUMN_TARGETACTIVE,
            RewardsSQL.COLUMN_TARGETCALORIES,
            RewardsSQL.COLUMN_TARGETMOVE,
            RewardsSQL.COLUMN_MERCHANT,
            RewardsSQL.COLUMN_IMAGEID,
            RewardsSQL.COLUMN_PROMOEND,
            RewardsSQL.COLUMN_PROMOSTART};

    /**
     *
     * @param context
     */
    public RewardDataSource(Context context) {

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
    public void insertData(Reward data){

        Reward reward = (Reward)data;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
        values.put(RewardsSQL.COLUMN_NAME, reward.getName());
        values.put(RewardsSQL.COLUMN_CLAIMED, reward.getClaimed());
        values.put(RewardsSQL.COLUMN_IMAGEID, reward.getImageid());
        values.put(RewardsSQL.COLUMN_MECHANICS, reward.getMechanics());
        values.put(RewardsSQL.COLUMN_MERCHANT, reward.getMerchant());
        values.put(RewardsSQL.COLUMN_PROMOEND, reward.getPromoend().toString());
        values.put(RewardsSQL.COLUMN_PROMOSTART, reward.getPromostart().toString());
        values.put(RewardsSQL.COLUMN_REWARDFLAG, reward.getRewardflag());
        values.put(RewardsSQL.COLUMN_TARGETACTIVE, reward.getTargetactive());
        values.put(RewardsSQL.COLUMN_TARGETCALORIES, reward.getTargetcalories());
        values.put(RewardsSQL.COLUMN_TARGETMOVE, reward.getTargetmove());
        values.put(RewardsSQL.COLUMN_TARGETSLEEP, reward.getTargetsleep());


        // INSERT VALUES TO TABLE
        long insertId = database.insert(RewardsSQL.TABLE_NAME, null, values);

    }

    /**
     *
     * @param data
     */
    public void getData(Reward data){

    }
}

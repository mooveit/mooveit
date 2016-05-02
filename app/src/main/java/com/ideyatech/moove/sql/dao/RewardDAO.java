package com.ideyatech.moove.sql.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ideyatech.moove.R;
import com.ideyatech.moove.sql.beans.Reward;
import com.ideyatech.moove.sql.SQLiteHelper;
import com.ideyatech.moove.sql.commands.RewardsSQL;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class RewardDAO {

    // Database fields
    private SQLiteDatabase database;
    private SQLiteHelper dbHelper;
    private String[] allColumns = {
            RewardsSQL.COLUMN_ID,
            RewardsSQL.COLUMN_NAME,
            RewardsSQL.COLUMN_CLAIMED,
            RewardsSQL.COLUMN_REWARDFLAG,
            RewardsSQL.COLUMN_MECHANICS,
            RewardsSQL.COLUMN_TARGET,
            RewardsSQL.COLUMN_MERCHANT,
            RewardsSQL.COLUMN_IMAGEID,
            RewardsSQL.COLUMN_PROMOEND,
            RewardsSQL.COLUMN_PROMOSTART};

    /**
     *
     * @param context
     */
    public RewardDAO(Context context) {

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
     * @param
     */
//    public void insertData(Reward data){
    public void insertData(){
//        Reward reward = (Reward)data;

        // COLLECT VALUES
        ContentValues values = new ContentValues();
//        values.put(RewardsSQL.COLUMN_NAME, reward.getName());
//        values.put(RewardsSQL.COLUMN_CLAIMED, reward.getClaimed());
//        values.put(RewardsSQL.COLUMN_IMAGEID, reward.getImageid());
//        values.put(RewardsSQL.COLUMN_MECHANICS, reward.getMechanics());
//        values.put(RewardsSQL.COLUMN_MERCHANT, reward.getMerchant());
//        values.put(RewardsSQL.COLUMN_PROMOEND, reward.getPromoend().toString());
//        values.put(RewardsSQL.COLUMN_PROMOSTART, reward.getPromostart().toString());
//        values.put(RewardsSQL.COLUMN_REWARDFLAG, reward.getRewardflag());
//        values.put(RewardsSQL.COLUMN_TARGET, reward.getTarget());


        // INSERT VALUES TO TABLE
        long insertId = database.insert(RewardsSQL.TABLE_NAME, null, values);

    }

    /**
     *
     * @param data
     */
    public List getData(Reward data){

        String[] name = new String[] {"GU Roctane Gels", "Adidas Trainer's Shoes", "Quest Bar Protein Bars", "Gold's Gym Membership"};
        String[] merchant = new String[] {"Toby's Sports", "Adidas Philippines", "Healthy Options", "Gold's Gym Philippines"};
        Integer[] imageId = new Integer[] {R.drawable.reward_gurew, R.drawable.reward_adidasrewards, R.drawable.reward_healthyrew, R.drawable.reward_goldrew};
        String[] description = new String[] {"Accumulate 20,000 moves to get this.", "Burn 5,000 calories in the next 24hrs to win.", "Sleep at least 8hrs for 5 consecutive days to get this", "Be active for more than 30mins. to get this."};
        String[] expiration = new String[] {"Expires in 3-days", "Expires in 5-days", "Expires in 1-week", "Expires in 1-month"};

        List<com.ideyatech.moove.ui.beans.Reward> lrew = new ArrayList<com.ideyatech.moove.ui.beans.Reward>();
        for (int i = 0; i < 4; i++){
            com.ideyatech.moove.ui.beans.Reward rew = new com.ideyatech.moove.ui.beans.Reward(imageId[i], name[i], merchant[i], description[i], expiration[i]);
            lrew.add(rew);
        }

        return lrew;
    }
}

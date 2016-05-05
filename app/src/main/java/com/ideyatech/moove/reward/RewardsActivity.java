package com.ideyatech.moove.reward;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.ideyatech.moove.R;
import com.ideyatech.moove.login.Moove;
import com.ideyatech.moove.main.MainActivity;
import com.ideyatech.moove.merchant.MerchantActivity;
import com.ideyatech.moove.ui.adapters.RewardAdapter;
import com.ideyatech.moove.ui.beans.Reward;
import com.ideyatech.moove.sql.dao.RewardDAO;

import java.util.List;

/**
 * Created by kendeng on 4/22/2016.
 */
public class RewardsActivity extends AppCompatActivity{

//    public static final String[] name = new String[] {"GU Roctane Gels", "Adidas Trainer's Shoes", "Quest Bar Protein Bars", "Gold's Gym Membership"};
//    public static final String[] merchant = new String[] {"Toby's Sports", "Adidas Philippines", "Healthy Options", "Gold's Gym Philippines"};
//    public static final Integer[] imageId = new Integer[] {R.drawable.gurew, R.drawable.adidasrew, R.drawable.healthyrew, R.drawable.goldrew};
//    public static final String[] description = new String[] {"Accumulate 20,000 moves to get this.", "Burn 5,000 calories in the next 24hrs to win.", "Sleep at least 8hrs for 5 consecutive days to get this", "Be active for more than 30mins. to get this."};
//    public static final String[] expiration = new String[] {"Expires in 3-days", "Expires in 5-days", "Expires in 1-week", "Expires in 1-month"};
//    public static final String[] mechanics = {"-sample\n-sample\n-sample", "-sample\n-sample\n-sample", "-sample\n-sample\n-sample", "-sample\n-sample\n-sample"};



    ListView listView;
    List<Reward> rewardItems;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reward);

        //*****************************************************************************************
        //*                                     TOOLBAR
        //*****************************************************************************************
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        RewardDAO rds = new RewardDAO(null);

        listView = (ListView) findViewById(R.id.reward_list);
        listView.setDivider(null);
//        RewardAdapter adapter = new RewardAdapter(this, rewardItems);
        RewardAdapter adapter = new RewardAdapter(this, rds.getData(null));
        listView.setAdapter(adapter);

        //*****************************************************************************************
        //*                                     BACK TO TITLE
        //*****************************************************************************************
        Button dash = (Button) findViewById(R.id.dash);
        Button merchant = (Button) findViewById(R.id.merchant);
//        Button account = (Button) findViewById()
        Button now = (Button) findViewById(R.id.reward);

        now.setBackgroundResource(R.drawable.buttons_rewardsactive);

        dash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        merchant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MerchantActivity.class);
                startActivity(i);
            }
        });

        //*****************************************************************************************
        //*                                     BACK TO TITLE
        //*****************************************************************************************
        ImageView home = (ImageView) findViewById(R.id.icon);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Moove.class);
                startActivity(i);
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case android.R.id.home: finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void claimreward(View view){
        TextView ty = (TextView) findViewById(R.id.name);
        Intent i = new Intent(getApplicationContext(), GU.class);
        i.putExtra("try", ty.getText().toString());
        startActivity(i);
    }

    public void onListItemClick(ListView l, View v, int position, long id){

    }
}
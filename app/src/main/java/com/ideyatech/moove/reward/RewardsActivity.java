package com.ideyatech.moove.reward;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
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
        //*                                         BUTTONS
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
        Intent i = new Intent(getApplicationContext(), ClaimRewardActivity.class);
        //Toast.makeText(getApplicationContext(), listView.getPositionForView(view) + "", Toast.LENGTH_LONG).show();
        i.putExtra("try", listView.getPositionForView(view) + "");
        startActivity(i);
    }
}
package com.ideyatech.moove.reward;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ideyatech.moove.R;
import com.ideyatech.moove.login.Moove;
import com.ideyatech.moove.main.MainActivity;
import com.ideyatech.moove.merchant.MerchantActivity;

/**
 * Created by kendeng on 4/25/2016.
 */
public class GU extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gu);

        //*****************************************************************************************
        //*                                     TOOLBAR
        //*****************************************************************************************
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //myToolbar.setTitle("Back");
        getSupportActionBar().setTitle("Back");

        Button claim = (Button) findViewById(R.id.claim);
        ImageView claimed = (ImageView) findViewById(R.id.claimed);

        //MINE
        Button dash = (Button) findViewById(R.id.dash);
        Button merchant = (Button) findViewById(R.id.merchantbutt);
//        Button account = (Button) findViewById()
        Button now = (Button) findViewById(R.id.rewardbutt);

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

        // caller


//        TextView rewardname = (TextView) findViewById(R.id.rewardname);
//        TextView mechanics = (TextView) findViewById(R.id.mechanics);
//        TextView merchant = (TextView) findViewById(R.id.merchant);
//        TextView website = (TextView) findViewById(R.id.website);
//        TextView other = (TextView) findViewById(R.id.other);
//        ImageView reward = (ImageView) findViewById(R.id.reward);
//        rewardname.setText("");

//        if(i==1) {
//            claim.setVisibility(View.INVISIBLE);
//            claimed.setVisibility(View.VISIBLE);
//        }
//        else {
            claim.setVisibility(View.VISIBLE);
            claimed.setVisibility(View.INVISIBLE);
//        }

        claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), qr.class);
                startActivity(i);
            }
        });

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case android.R.id.home: finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

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

/**
 * Created by kendeng on 4/25/2016.
 */
public class GU extends AppCompatActivity {

    int i = 0;

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
//            claim.setVisibility(View.VISIBLE);
//            claimed.setVisibility(View.INVISIBLE);
//        }

        claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i = 1;
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

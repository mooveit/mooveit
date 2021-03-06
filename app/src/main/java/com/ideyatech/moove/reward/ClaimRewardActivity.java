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
import com.ideyatech.moove.main.MainActivity;
import com.ideyatech.moove.merchant.MerchantActivity;

/**
 * Created by kendeng on 4/25/2016.
 */
public class ClaimRewardActivity extends AppCompatActivity {

    public static boolean claimed_1 = false;
    public static boolean claimed_2 = false;
    public static boolean claimed_3 = false;
    public static boolean claimed_4 = false;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.claimreward);

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if(extras != null){
            if (extras.containsKey("try")){

                if(extras.getString("try").equals("1")){
//                    Toast.makeText(getApplicationContext(), extras.getString("try"), Toast.LENGTH_LONG).show();
                    ImageView icon = (ImageView) findViewById(R.id.reward);
                    icon.setImageResource(R.drawable.adidasrew);
                    TextView rewardname = (TextView) findViewById(R.id.rewardname);
                    rewardname.setText("Adidas Trainer's Shoes");
                    TextView merchantname = (TextView) findViewById(R.id.website);
                    merchantname.setText("Adidas Philippines (http://shop.adidas.com.ph)");
                }
                else if(extras.getString("try").equals("2")){
//                    Toast.makeText(getApplicationContext(), extras.getString("try"), Toast.LENGTH_LONG).show();
                    ImageView icon = (ImageView) findViewById(R.id.reward);
                    icon.setImageResource(R.drawable.healthyrew);
                    TextView rewardname = (TextView) findViewById(R.id.rewardname);
                    rewardname.setText("Quest Bar Protein Bars");
                    TextView merchantname = (TextView) findViewById(R.id.website);
                    merchantname.setText("Healthy Options (http://www.healthyoptions.com.ph)");
                }
                else if(extras.getString("try").equals("3")){
//                    Toast.makeText(getApplicationContext(), extras.getString("try"), Toast.LENGTH_LONG).show();
                    ImageView icon = (ImageView) findViewById(R.id.reward);
                    icon.setImageResource(R.drawable.goldrew);
                    TextView rewardname = (TextView) findViewById(R.id.rewardname);
                    rewardname.setText("Gold's Gym Membership");
                    TextView merchantname = (TextView) findViewById(R.id.website);
                    merchantname.setText("Gold's Gym Philippines (http://www.goldsgym.com.ph)");
                }
            }
        }

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

        //*****************************************************************************************
        //*                                         BUTTONS
        //*****************************************************************************************
        Button claim = (Button) findViewById(R.id.claim);
        final ImageView claimed = (ImageView) findViewById(R.id.claimed);

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


        if(!claimed_1){
            claim.setVisibility(View.VISIBLE);
            claimed.setVisibility(View.INVISIBLE);
        }
        else{
            claim.setVisibility(View.INVISIBLE);
            claimed.setVisibility(View.VISIBLE);
        }

        claim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), qr.class);
                claimed_1 = true;

                startActivity(i);
                finish();
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

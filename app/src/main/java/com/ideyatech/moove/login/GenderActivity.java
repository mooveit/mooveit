package com.ideyatech.moove.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.ideyatech.moove.R;

/**
 * Created by kendeng on 4/27/2016.
 */
public class GenderActivity extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.gender);

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

        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =  new Intent(getApplicationContext(), HeightActivity.class);
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

    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch(item.getItemId()){
            case android.R.id.home: finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

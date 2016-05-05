package com.ideyatech.moove.login;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ideyatech.moove.R;

/**
 * Created by kendeng on 4/28/2016.
 */
public class LastStepActivity extends AppCompatActivity {

    private static EditText user;
    private static EditText pass;
    private static CheckBox agree;


    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.laststep);

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

        user = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        agree = (CheckBox) findViewById(R.id.check);

        final Drawable originalDrawablePassword = pass.getBackground();
        final Drawable wrappedDrawablePassword = DrawableCompat.wrap(originalDrawablePassword);
        DrawableCompat.setTintList(wrappedDrawablePassword, ColorStateList.valueOf(Color.WHITE));
        pass.setBackground(wrappedDrawablePassword);

        final Drawable originalDrawableUser = user.getBackground();
        final Drawable wrappedDrawableUser = DrawableCompat.wrap(originalDrawableUser);
        DrawableCompat.setTintList(wrappedDrawableUser, ColorStateList.valueOf(Color.WHITE));
        user.setBackground(wrappedDrawableUser);



    Button next = (Button) findViewById(R.id.finish);
    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (agree.isChecked()) {
                Intent i = new Intent(getApplicationContext(), Login.class);
                i.putExtra("usern", user.getText().toString());
                i.putExtra("passn", pass.getText().toString());
                startActivity(i);
            }
            else{
                Toast.makeText(getApplicationContext(), "Please agree to Terms and Conditions", Toast.LENGTH_LONG).show();
            }

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

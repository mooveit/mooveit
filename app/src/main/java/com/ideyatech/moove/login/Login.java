package com.ideyatech.moove.login;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.ideyatech.moove.main.MainActivity;
import com.ideyatech.moove.R;
import com.ideyatech.moove.sql.SQLiteHelper;

/**
 * Created by kendeng on 4/25/2016.
 */
public class Login extends AppCompatActivity {

    private static boolean access;
    private static EditText user;
    private static EditText pass;
    private static Button   log;
    public static SQLiteHelper dBHelper;
    public boolean validUser;
    /*
     *
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        Log.d("Login", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //*****************************************************************************************
        //*                                SET-UP DB HELPER
        //*****************************************************************************************

        dBHelper = new SQLiteHelper(this);
        // open to read and write
        dBHelper.getWritableDatabase();


        //*****************************************************************************************
        //*                           EDITTEXT ASSIGNING AND FORMATTING
        //*****************************************************************************************

        user = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        log = (Button) findViewById(R.id.butt);

        final Drawable originalDrawablePassword = pass.getBackground();
        final Drawable wrappedDrawablePassword = DrawableCompat.wrap(originalDrawablePassword);
        DrawableCompat.setTintList(wrappedDrawablePassword, ColorStateList.valueOf(Color.WHITE));
        pass.setBackground(wrappedDrawablePassword);

        final Drawable originalDrawableUser = user.getBackground();
        final Drawable wrappedDrawableUser = DrawableCompat.wrap(originalDrawableUser);
        DrawableCompat.setTintList(wrappedDrawableUser, ColorStateList.valueOf(Color.WHITE));
        user.setBackground(wrappedDrawableUser);

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if(extras != null){
            if (extras.containsKey("usern") && extras.containsKey("passn")){
                user.setText(getIntent().getExtras().getString("usern"));
                pass.setText(extras.getString("passn"));
            }
        }

        //*****************************************************************
        //                          VALIDATION
        //*****************************************************************
        String fullname = dBHelper.validateUsernameAndPassword(user.getText().toString(), pass.getText().toString());
        validUser = fullname.equals("EMPTY")? false: true;
        Log.d("Login", "FULLNAME OF USER " +  fullname);



        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(access) {

//                    startActivity(i);
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Invalid User Access", Toast.LENGTH_LONG).show();
//                }
            Intent i = new Intent(getApplicationContext(), MainActivity.class);
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
}

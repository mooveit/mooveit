package com.ideyatech.moove.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ideyatech.moove.MainActivity;
import com.ideyatech.moove.R;
import com.ideyatech.moove.sql.dataSource.UserDataSource;

/**
 * Created by kendeng on 4/25/2016.
 */
public class Login extends AppCompatActivity {

    private static boolean access;
    private static EditText user;
    private static EditText pass;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        user = (EditText) findViewById(R.id.editText);
        pass = (EditText) findViewById(R.id.editText2);
        Button log = (Button) findViewById(R.id.butt);

        access = false;

        if(user.getText().toString().equals("user"))
            if(pass.getText().toString().equals("password"))
                access = true;


        Log.d("KING", "KING");

        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if(access) {
//                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
//                    startActivity(i);
//                }
//                else {
//                    Toast.makeText(getApplicationContext(), "Invalid User Access", Toast.LENGTH_LONG).show();
//                }
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);

            }
        });

    }
}

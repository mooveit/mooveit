package com.ideyatech.moove.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ideyatech.moove.R;
import com.ideyatech.moove.device.ChooseDevice;

/**
 * Created by kendeng on 4/25/2016.
 */
public class Moove extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.moove);



        Button log = (Button) findViewById(R.id.butt);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), ChooseDevice.class);
                startActivity(i);

            }
        });

        Button noacc = (Button) findViewById(R.id.noacc);
        noacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =  new Intent(getApplicationContext(), SearchDeviceActivity.class);
                startActivity(i);

            }
        });

    }

}

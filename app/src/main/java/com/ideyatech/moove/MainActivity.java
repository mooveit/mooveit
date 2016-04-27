package com.ideyatech.moove;
import java.util.ArrayList;
import java.util.List;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.ideyatech.moove.adapters.CustomBaseAdapter;
import com.ideyatech.moove.beans.DashboardRowItem;


public class MainActivity extends AppCompatActivity implements
        OnItemClickListener {

    public static final String[] values = new String[] { "2200" + " moves",
            "180" + " calories", "13 hrs. 08 mins.", "8" + " minutes active"};

    
    public static final String[] rewardComment = new String[] {
            "You need 500 moves to get reward",
            "Burn 3000 calories to get reward",
            "You've slept way too much!",
            "Be active for 23 mins. to get a reward"};

    public static final Integer[] images = { R.drawable.step,
            R.drawable.fire, R.drawable.sleep, R.drawable.active };

    ListView listView;
    List<DashboardRowItem> dashboardRowItems;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //*****************************************************************************************
        //*                                     TOOLBAR
        //*****************************************************************************************
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //MINE
        Button reward = (Button) findViewById(R.id.dash);

        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RewardsActivity.class);
                startActivity(i);
            }
        });

        dashboardRowItems = new ArrayList<DashboardRowItem>();
        for (int i = 0; i < values.length; i++) {
            DashboardRowItem item = new DashboardRowItem(images[i], values[i], rewardComment[i]);
            dashboardRowItems.add(item);
        }

        listView = (ListView) findViewById(R.id.list);
        // No Border
        listView.setDivider(null);
        CustomBaseAdapter adapter = new CustomBaseAdapter(this, dashboardRowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    /**
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + dashboardRowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }
}
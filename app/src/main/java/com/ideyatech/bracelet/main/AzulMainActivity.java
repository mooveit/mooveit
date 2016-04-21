package com.ideyatech.bracelet.main;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.Image;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;

import com.ideyatech.bracelet.steps.StepsActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AzulMainActivity extends AppCompatActivity {


    private DrawerLayout mDrawerLayout;
    protected ListView mDrawerList;

    BraceletService stepInList = new BraceletService("1000", "You need 500 steps more to get a reward", "@drawable/step");
    BraceletService calorieInList = new BraceletService("2000", "Burn!", "@drawable/calories_burned");
    BraceletService activeInList = new BraceletService("3000", "Be Active in next 5 Minutes!", "@drawable/active");

    protected BraceletService [] arrayOfBraceletService = {stepInList, calorieInList, activeInList};

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //*****************************************************************************************
        //                            SET LAYOUT XML OF ACTIVITY
        //*****************************************************************************************
        setContentView(R.layout.activity_azul_main);

        //*****************************************************************************************
        //*                                     TOOLBAR
        //*****************************************************************************************
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        ArrayAdapter itemsAdapter = new ArrayAdapter(this, R.layout.adapter_layout);
        final ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(itemsAdapter);






        //*****************************************************************************************
        //*                     CREATE ARRAYLIST
        //*****************************************************************************************
        final ArrayList<BraceletService> list = new ArrayList<BraceletService>();
        for (int i = 0; i < arrayOfBraceletService.length; ++i) {
            list.add(arrayOfBraceletService[i]);
        }

        // our adapter instance
//        ArrayAdapterItem adapter = new ArrayAdapterItem(this, R.layout.list_view_row_item, ObjectItemData);




//        ArrayAdapter itemsAdapter = new ArrayAdapter(this, R.layout.adapter_layout,R.id.fitIcon, R.id.firstLine, R.id.secondLine);
//
//        final ListView listview = (ListView) findViewById(R.id.listview);
//        listview.setAdapter();
//
//        String[] values = new String[] { "Android", "iPhone", "WindowsMobile",
//                "Blackberry", "WebOS", "Ubuntu", "Windows7", "Max OS X",
//                "Linux", "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux",
//                "OS/2", "Ubuntu", "Windows7", "Max OS X", "Linux", "OS/2",
//                "Android", "iPhone", "WindowsMobile" };
//
//        final ArrayList<String> list = new ArrayList<String>();
//        for (int i = 0; i < values.length; ++i) {
//            list.add(values[i]);
//        }

//        final StableArrayAdapter adapter = new StableArrayAdapter(this,
//                android.R.layout.simple_list_item_1, list);
//        listview.setAdapter(adapter);

//        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout,myToolbar,R.string.app_name,R.string.app_name);
//        mDrawerLayout.setDrawerListener(actionBarDrawerToggle);

//        // Set the adapter for the list view
//        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
//                R.layout.drawer_list_item, mPlanetTitles));
//        // Set the list's click listener
//        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());


        //*****************************************************************************************
        //             SET TEXT VIEW WITH DATA FROM BRACELETS and MAKE STEPS CLICKABLE
        //*****************************************************************************************

        TextView steps = (TextView) findViewById(R.id.steps_numbers); steps.setText("958");



    }


    /**
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        //*****************************************************************************************
        //*                                 SET UP MENU LAY OUT XML
        //*****************************************************************************************
        getMenuInflater().inflate(R.menu.menu_azul_main, menu);
        return true;

    }

    /**
     *
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

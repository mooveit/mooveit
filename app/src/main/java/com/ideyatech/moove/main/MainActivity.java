package com.ideyatech.moove.main;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.hardware.*;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.Fitness;
import com.google.android.gms.fitness.data.DataPoint;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.fitness.data.Value;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.OnDataPointListener;
import com.google.android.gms.fitness.request.SensorRequest;
import com.google.android.gms.fitness.result.DataSourcesResult;
import com.ideyatech.moove.R;
import com.ideyatech.moove.barchart.BarChartActivity;
import com.ideyatech.moove.login.Moove;
import com.ideyatech.moove.merchant.MerchantActivity;
import com.ideyatech.moove.reward.RewardsActivity;
import com.ideyatech.moove.ui.adapters.DashboardAdaptor;
import com.ideyatech.moove.ui.beans.DashboardRowItem;


public class MainActivity extends AppCompatActivity implements OnItemClickListener, SensorEventListener {

    private SensorManager sensorManager;
    private TextView count;
    boolean activityRunning;
    private GoogleApiClient mClient = null;
    private OnDataPointListener mListener;

    public static final String[] values = new String[] { "0",
            "20,000", "12", "8", "75"};

    public static final String[] units = new String[] { "moves",
            "calories burned", "hours", " minutes active", "kilos"};
    
    public static final String[] rewardComment = new String[] {
            "You need 500 moves to get reward",
            "Burn 30,000 calories to get reward",
            "You've slept way too much!",
            "Be active for 23mins. to get a reward",
            "You still need to lose 3 kilos."};

    public static final Integer[] images = { R.drawable.dashboard_step,
            R.drawable.dashboard_fire, R.drawable.dashboard_sleep, R.drawable.dashboard_active, R.drawable.dashboard_weight};

    public static final Integer[] image = { R.drawable.dashboard_star, R.drawable.arrow };

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

        //sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        Log.d("HELLO", "SONNY 1");

        setContentView(R.layout.activity_main);

        buildFitnessClient();

        //*****************************************************************************************
        //*                                     TOOLBAR
        //*****************************************************************************************
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        Log.d("HELLO", "SONNY 2");



        //*****************************************************************************************
        //*                                      BUTTONS
        //*****************************************************************************************
        Button reward = (Button) findViewById(R.id.reward);
        Button merchant = (Button) findViewById(R.id.merchant);
        Button now = (Button) findViewById(R.id.dash);

        now.setBackgroundResource(R.drawable.buttons_dashboardactive);

        reward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), RewardsActivity.class);
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



        //*****************************************************************************************
        //*                                     DASHBOARD LIST
        //*****************************************************************************************

        dashboardRowItems = new ArrayList<DashboardRowItem>();
        for (int i = 0; i < values.length; i++) {
                if (i == 0) {
                    DashboardRowItem item = new DashboardRowItem(images[i], values[i], units[i], image[0], rewardComment[i], image[1]);
                    dashboardRowItems.add(item);
                } else if ((i == 1) || (i ==3)){
                    DashboardRowItem item = new DashboardRowItem(images[i], values[i], units[i], image[0], rewardComment[i], 0);
                    dashboardRowItems.add(item);
                }else{
                    DashboardRowItem item = new DashboardRowItem(images[i], values[i], units[i], 0, rewardComment[i], 0);
                    dashboardRowItems.add(item);
                }
        }

        listView = (ListView) findViewById(R.id.list);
        // No Border
        listView.setDivider(null);
        DashboardAdaptor adapter = new DashboardAdaptor(this, dashboardRowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);


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
//        Toast toast = Toast.makeText(getApplicationContext(),
//                "Item " + (position + 1) + ": " + dashboardRowItems.get(position),
//                Toast.LENGTH_SHORT);
//        toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL, 0, 0);
//        toast.show();
//        Log.d("king", "garcia");

    }

    /**
     *
     * @param view
     */
    public void bar(View view){
        Intent i = new Intent(getApplicationContext(), BarChartActivity.class);
        startActivity(i);

    }


    /**
     *
     */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("HELLO", "SONNY 3");
//        activityRunning = true;
//        Sensor countSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
//        if (countSensor != null) {
//            sensorManager.registerListener(this, countSensor, SensorManager.SENSOR_DELAY_UI);
//        } else {
//            Toast.makeText(this, "Count sensor not available!", Toast.LENGTH_LONG).show();
//        }

    }

//    @Override
//    public void onStart(){
//        Log.d("HELLO", "Sonny Connect 1");
//        super.onStart();
//        Log.d("HELLO", "Sonny Connect 2");
//        mClient.connect();
//        Log.d("HELLO", "Sonny Connect 3");
//    }

    @Override
    protected void onPause() {
        super.onPause();
        activityRunning = false;
        // if you unregister the last listener, the hardware will stop detecting step events
//        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (activityRunning) {
            values[0] = (String.valueOf(event.values[0]/2));
            // count.setText(String.valueOf(event.values[0]));

        }

    }

    /**
     *
     * @param sensor
     * @param accuracy
     */
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    //******************************************************************************************
    //*                                             NOY
    //******************************************************************************************
    private void buildFitnessClient() {

            Log.d("HELLO", "SONNY 4.4");
            mClient = new GoogleApiClient.Builder(this)
                    .addApi(Fitness.RECORDING_API)
                    .addScope(new Scope(Scopes.FITNESS_ACTIVITY_READ))
                    .addConnectionCallbacks(
                            new GoogleApiClient.ConnectionCallbacks() {

                                @Override
                                public void onConnected(Bundle bundle) {
                                    Log.i("MAIN", "Connected!!!");
                                    Log.d("HELLO", "SONNY 4.5");
                                    // Now you can make calls to the Fitness APIs.
                                    findFitnessDataSources();
                                }

                                @Override
                                public void onConnectionSuspended(int i) {
                                    Log.d("HELLO", "SONNY 5");
                                    // If your connection to the sensor gets lost at some point,
                                    // you'll be able to determine the reason and react to it here.
                                    if (i == GoogleApiClient.ConnectionCallbacks.CAUSE_NETWORK_LOST) {
                                        Log.i("MAIN", "Connection lost.  Cause: Network Lost.");
                                    } else if (i
                                            == GoogleApiClient.ConnectionCallbacks.CAUSE_SERVICE_DISCONNECTED) {
                                        Log.i("MAIN", "Connection lost.  Reason: Service Disconnected");
                                    }
                                }
                            }
                    )
                    .enableAutoManage(this, 0, new GoogleApiClient.OnConnectionFailedListener() {
                        @Override
                        public void onConnectionFailed(ConnectionResult result) {
                            Log.d("HELLO", "SONNY 4.7");
                            Log.i("MAIN", "Google Play services connection failed. Cause: " +
                                    result.toString());
//                            Snackbar.make(
//                                    MainActivity.this.findViewById(R.id.main_activity_view),
//                                    "Exception while connecting to Google Play services: " +
//                                            result.getErrorMessage(),
//                                    Snackbar.LENGTH_INDEFINITE).show();
                        }
                    })
                    .build();
        }


    /**
     *
     * @param dataSource
     * @param dataType
     */
    private void registerFitnessDataListener(DataSource dataSource, DataType dataType) {
        Log.i("HELLO", "SONNY 9");
        // [START register_data_listener]
        mListener = new OnDataPointListener() {
            @Override
            public void onDataPoint(DataPoint dataPoint) {
                for (Field field : dataPoint.getDataType().getFields()) {
                    Value val = dataPoint.getValue(field);
                    Log.i("HELLO", "SONNY 9.9");
                    Log.i("MAIN", "Detected DataPoint field: " + field.getName());
                    Log.i("MAIN", "Detected DataPoint value: " + val);
                }
            }
        };

        //******************************************************************************************
        //*                                             NOY
        //******************************************************************************************

        Fitness.SensorsApi.add(
                mClient,
                new SensorRequest.Builder()
                        .setDataSource(dataSource) // Optional but recommended for custom data sets.
                        .setDataType(dataType) // Can't be omitted.
                        .setSamplingRate(1, TimeUnit.SECONDS)
                        .build(),
                mListener)
                .setResultCallback(new ResultCallback<Status>() {
                    @Override
                    public void onResult(Status status) {
                        if (status.isSuccess()) {
                            Log.i("MAIN", "Listener registered!");
                        } else {
                            Log.i("MAIN", "Listener not registered.");
                        }
                    }
                });
        // [END register_data_listener]
    }

    /**
     *
     * @return
     */
    private boolean checkPermissions(){

        String permission = "android.permission.ACCESS_FINE_LOCATION";
        int res = this.checkCallingOrSelfPermission(permission);
        return (res == PackageManager.PERMISSION_GRANTED);
    }


    /**
     *
     * @return
     */
    private void findFitnessDataSources(){

//        Log.d("HELLO", "SONNY 7");
//        // Note: Fitness.SensorsApi.findDataSources() requires the ACCESS_FINE_LOCATION permission.
//        Fitness.RECORDING_API.getName().findDataSources(mClient, new DataSourcesRequest.Builder()
//                // At least one datatype must be specified.
//                .setDataTypes(DataType.TYPE_STEP_COUNT_CUMULATIVE)
//                        // Can specify whether data type is raw or derived.
//                .setDataSourceTypes(DataSource.TYPE_RAW)
//                .build())
//                .setResultCallback(new ResultCallback<DataSourcesResult>() {
//                    @Override
//                    public void onResult(DataSourcesResult dataSourcesResult) {
//                        Log.i("MAIN", "Result: " + dataSourcesResult.getStatus().toString());
//                        for (DataSource dataSource : dataSourcesResult.getDataSources()) {
//                            Log.i("MAIN", "Data source found: " + dataSource.toString());
//                            Log.i("MAIN", "Data Source type: " + dataSource.getDataType().getName());
//
//                            //Let's register a listener to receive Activity data!
//                            if (dataSource.getDataType().equals(DataType.TYPE_STEP_COUNT_CUMULATIVE)
//                                    && mListener == null) {
//                                Log.i("MAIN", "Data source for LOCATION_SAMPLE found!  Registering.");
//                                registerFitnessDataListener(dataSource,
//                                        DataType.TYPE_STEP_COUNT_CUMULATIVE);
//                            }
//                        }
//                    }
//                });
    }



}
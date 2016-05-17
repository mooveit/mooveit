package com.ideyatech.moove.barchart;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.ideyatech.moove.R;
import com.ideyatech.moove.login.Moove;
import com.ideyatech.moove.main.MainActivity;
import com.ideyatech.moove.merchant.MerchantActivity;
import com.ideyatech.moove.reward.RewardsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kendeng on 4/27/2016.
 */
public class BarChartActivity extends AppCompatActivity {

    private TabLayout tabLayout;        // Tab
    private ViewPager viewPager;        // ViewPager

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.bar);

        Intent i = getIntent();
        Bundle extras = i.getExtras();

        if(extras != null){
            if (extras.containsKey("bar")){
                Toast.makeText(getApplicationContext(), extras.getString("bar"), Toast.LENGTH_LONG).show();
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

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

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
     * @param viewPager
     */
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new HourlyDashboardCalendarFragment(), "HOURLY");
        adapter.addFragment(new DailyDashboardCalendarFragment(), "DAILY");
        adapter.addFragment(new WeeklyDashboardCalendarFragment(), "WEEKLY");
        adapter.addFragment(new MonthlyDashboardCalendarFragment(), "MONTHLY");
        viewPager.setAdapter(adapter);
    }

    /**
     *
     */
    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
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

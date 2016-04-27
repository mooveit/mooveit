package com.ideyatech.moove;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import com.ideyatech.moove.adapters.MerchantAdapter;
import com.ideyatech.moove.beans.Merchant;
import com.ideyatech.moove.sql.dataSource.MerchantDataSource;

import java.util.ArrayList;
import java.util.List;

public class MerchantActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

//    public static final String[] name = new String[] {"Toby's Sports", "Adidas Philippines", "Healthy Options", "Gold's Gym Philippines"};
//    public static final Integer[] logoId = new Integer[] {R.drawable.tobylogo, R.drawable.adidaslogo, R.drawable.healthylogo, R.drawable.goldlogo};
//    public static final String[] website = new String[] {"http://www.tobys.com", "http://shop.adidas.com.ph", "http://www.healthyoptions.com.ph", "http://www.goldsgym.com.ph"};


    ListView listView;
    List<Merchant> merchantItems;

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merchant);

        //*****************************************************************************************
        //*                                     TOOLBAR
        //*****************************************************************************************
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_awesome_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        MerchantDataSource mds = new MerchantDataSource(null);
//        mds.insertData(null);

//        merchantItems = new ArrayList<Merchant>();
//        for (int i = 0; i < name.length ; i++){
//            Merchant item = new Merchant(logoId[i], name[i], website[i]);
//            merchantItems.add(item);
//        }

        listView = (ListView) findViewById(R.id.merchant_list);
        listView.setDivider(null);
        MerchantAdapter adapter = new MerchantAdapter(this, mds.getData(null));
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position,
                            long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Item " + (position + 1) + ": " + merchantItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM| Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();
    }

}
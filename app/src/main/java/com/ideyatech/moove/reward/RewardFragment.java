package com.ideyatech.moove.reward;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.ideyatech.moove.R;
import com.ideyatech.moove.sql.dao.RewardDAO;
import com.ideyatech.moove.ui.adapters.RewardAdapter;

/**
 * Created by kendeng on 5/4/2016.
 */
public class RewardFragment extends ListFragment implements AdapterView.OnItemClickListener {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.reward_list, container, false);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        RewardDAO rds = new RewardDAO(null);
        RewardAdapter adapter = new RewardAdapter(null, rds.getData(null));
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
    }

}

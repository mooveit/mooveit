package com.ideyatech.moove.barchart;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.ideyatech.moove.R;

import java.util.ArrayList;

/**
 * Created by kendeng on 4/27/2016.
 */
public class WeeklyDashboardCalendarFragment extends Fragment implements IDashboardCalendarFragment {


    /**
     *
     */
    public WeeklyDashboardCalendarFragment() {
        // Required empty public constructor
    }

    /**
     *
     * @param savedInstanceState
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v =inflater.inflate(R.layout.fragment_weekly_dashboard,container,false);

        //*******************************************************************
        //                      BACKGROUND TO WHITE
        //*******************************************************************

        View root = v.getRootView();
        // Set the color to white
        root.setBackgroundColor(getResources().getColor(android.R.color.white));

        BarChart chart = (BarChart) v.findViewById(R.id.weeklychart);

        // Get X Values and Get Data
        BarData data = new BarData(getXAxisValues(),getDataSet());

        //Get Legend and Disable Legend
        Legend l = chart.getLegend();
        l.setEnabled(false);

        // Disable Description
        chart.setDescription(null);
        chart.setData(data);
        chart.animateXY(2000, 2000);
        chart.setDrawGridBackground(false);
        chart.setScrollContainer(false);
        chart.setPinchZoom(false);
        chart.invalidate();
        chart.setTouchEnabled(false);
        chart.setClickable(false);
        chart.setDrawMarkerViews(false);
        chart.setDrawGridBackground(false);
        chart.setVerticalFadingEdgeEnabled(true);

        return v;
    }

    /**
     *
     * @return
     */
    private ArrayList<BarDataSet> getDataSet() {

        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry am1 = new BarEntry(95000, 0);
        valueSet1.add(am1);
        BarEntry am2 = new BarEntry(35000, 1);
        valueSet1.add(am2);
        BarEntry am3 = new BarEntry(85000, 2);
        valueSet1.add(am3);
        BarEntry am4 = new BarEntry(100000, 3);
        valueSet1.add(am4);
        BarEntry am5 = new BarEntry(10000, 4);
        valueSet1.add(am5);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, null);
        // Color Green
        barDataSet1.setColor(Color.rgb(75, 0, 130));


        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);

        return dataSets;
    }

    /**
     *
     * @return
     */
    private ArrayList<String> getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("WEEK 1");
        xAxis.add("WEEK 2");
        xAxis.add("WEEK 3");
        xAxis.add("WEEK 4");
        xAxis.add("WEEK 5");

        return xAxis;
    }


}
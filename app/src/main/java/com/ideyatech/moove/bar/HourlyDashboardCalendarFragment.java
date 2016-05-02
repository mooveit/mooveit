package com.ideyatech.moove.bar;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.ideyatech.moove.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kendeng on 4/27/2016.
 */
public class HourlyDashboardCalendarFragment extends Fragment implements IDashboardCalendarFragment {

    /**
     *
     */
    public HourlyDashboardCalendarFragment() {
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

        View v =inflater.inflate(R.layout.fragment_hourly_dashboard,container,false);

        //*******************************************************************
        //                      BACKGROUND TO WHITE
        //*******************************************************************

        View root = v.getRootView();
        // Set the color to white
        root.setBackgroundColor(getResources().getColor(android.R.color.white));

        BarChart chart = (BarChart) v.findViewById(R.id.hourlychart);

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
        BarEntry am1 = new BarEntry(600, 0);
        valueSet1.add(am1);
        BarEntry am2 = new BarEntry(100, 1);
        valueSet1.add(am2);
        BarEntry am3 = new BarEntry(500, 2);
        valueSet1.add(am3);
        BarEntry am4 = new BarEntry(100, 3);
        valueSet1.add(am4);
        BarEntry am5 = new BarEntry(1000, 4);
        valueSet1.add(am5);
        BarEntry am6 = new BarEntry(700, 5);
        valueSet1.add(am6);
        BarEntry am7 = new BarEntry(900, 6);
        valueSet1.add(am7);
        BarEntry am8 = new BarEntry(300, 7);
        valueSet1.add(am8);
        BarEntry am9 = new BarEntry(900, 8);
        valueSet1.add(am9);
        BarEntry am10 = new BarEntry(900, 9);
        valueSet1.add(am10);
        BarEntry am11 = new BarEntry(800, 10);
        valueSet1.add(am11);
        BarEntry am12 = new BarEntry(700, 11);
        valueSet1.add(am12);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, null);
        // Color Orange
        barDataSet1.setColor(Color.rgb(255, 165, 0));

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
        xAxis.add("1 AM");
        xAxis.add("2 AM");
        xAxis.add("3 AM");
        xAxis.add("4 AM");
        xAxis.add("5 AM");
        xAxis.add("6 AM");
        xAxis.add("7 AM");
        xAxis.add("8 AM");
        xAxis.add("9 AM");
        xAxis.add("10 AM");
        xAxis.add("11 AM");
        xAxis.add("12 AM");
        return xAxis;
    }


}
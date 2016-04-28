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
import com.ideyatech.moove.bar.ui.adapter.CalendarAdapter;
import com.ideyatech.moove.bar.ui.beans.DashboardCalendarData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kendeng on 4/27/2016.
 */
public class MonthlyDashboardCalendarFragment extends Fragment implements IDashboardCalendarFragment {

    /**
     *
     */
    public MonthlyDashboardCalendarFragment() {
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

        View v =inflater.inflate(R.layout.fragment_monthly_dashboard,container,false);

        BarChart chart = (BarChart) v.findViewById(R.id.monthlychart);

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

        ListView listView;
        List<DashboardCalendarData> dashboardRowItems;

        dashboardRowItems = new ArrayList<DashboardCalendarData>();
        dashboardRowItems.add(new DashboardCalendarData("1AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("2AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("3AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("4AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("5AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("6AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("7AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("8AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("9AM", "122"));
        dashboardRowItems.add(new DashboardCalendarData("10AM","122"));
        dashboardRowItems.add(new DashboardCalendarData("11AM","122"));
        dashboardRowItems.add(new DashboardCalendarData("12AM", "122"));


        listView = (ListView)  v.findViewById(R.id.monthlylist);
        CalendarAdapter adapter = new CalendarAdapter(getActivity().getBaseContext(), dashboardRowItems);
        listView.setAdapter(adapter);

        return v;
    }

    /**
     *
     * @return
     */
    private ArrayList<BarDataSet> getDataSet() {

        ArrayList<BarDataSet> dataSets = null;

        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry am1 = new BarEntry(9000, 0);
        valueSet1.add(am1);
        BarEntry am2 = new BarEntry(1000, 1);
        valueSet1.add(am2);
        BarEntry am3 = new BarEntry(8000, 2);
        valueSet1.add(am3);
        BarEntry am4 = new BarEntry(4000, 3);
        valueSet1.add(am4);
        BarEntry am5 = new BarEntry(2000, 4);
        valueSet1.add(am5);
        BarEntry am6 = new BarEntry(10000, 5);
        valueSet1.add(am6);
        BarEntry am7 = new BarEntry(6000, 6);
        valueSet1.add(am7);
        BarEntry am8 = new BarEntry(2000, 7);
        valueSet1.add(am8);
        BarEntry am9 = new BarEntry(5000, 8);
        valueSet1.add(am9);
        BarEntry am10 = new BarEntry(4000, 9);
        valueSet1.add(am10);
        BarEntry am11 = new BarEntry(300, 10);
        valueSet1.add(am11);
        BarEntry am12 = new BarEntry(7000, 11);
        valueSet1.add(am12);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, null);
        // Color Green
        barDataSet1.setColor(Color.rgb(255, 20, 147));


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
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        xAxis.add("JUL");
        xAxis.add("AUG");
        xAxis.add("SEP");
        xAxis.add("OCT");
        xAxis.add("NOV");
        xAxis.add("DEC");
        return xAxis;

    }
}

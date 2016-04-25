package com.ideyatech.moove.sql.dataSource;

import com.ideyatech.moove.sql.bean.DashboardItems;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public interface DashboardDataSource {

    public abstract ArrayList<Integer> getDataPerHour(Date date);
    public abstract ArrayList<Integer> getDataPerDay(Date date);
    public abstract ArrayList<Integer> getDataPerMonth(Date date);
    public abstract ArrayList<Integer> getDataPerYear(Date date);
    public abstract void insertData(DashboardItems dashboardItems);

}

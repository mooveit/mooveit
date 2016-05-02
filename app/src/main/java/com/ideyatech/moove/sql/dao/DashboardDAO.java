package com.ideyatech.moove.sql.dao;

import com.ideyatech.moove.sql.beans.DashboardItems;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public interface DashboardDAO {

    public abstract ArrayList<Integer> getDataPerHour(Date date);
    public abstract ArrayList<Integer> getDataPerDay(Date date);
    public abstract ArrayList<Integer> getDataPerMonth(Date date);
    public abstract ArrayList<Integer> getDataPerYear(Date date);
    public abstract void insertData(DashboardItems dashboardItems);

}

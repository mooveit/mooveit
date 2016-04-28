package com.ideyatech.moove.bar.ui.beans;

/**
 * Created by kendeng on 4/27/2016.
 */
public class DashboardCalendarData<Any, Value> {

    public Any a;
    public Value v;

    /**
     *
     * @param a
     * @param v
     */
    public DashboardCalendarData(Any a,Value v){
        this.a = a;
        this.v = v;
    }

    public Any getA() {
        return a;
    }

    public void setA(Any a) {
        this.a = a;
    }

    public Value getV() {
        return v;
    }

    public void setV(Value v) {
        this.v = v;
    }
}

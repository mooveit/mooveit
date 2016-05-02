package com.ideyatech.moove.ble;
import android.os.Parcel;
import android.os.Parcelable;

public class ActivityData implements Parcelable{

    /**
     *
     */
    public static final Creator<ActivityData> CREATOR = new Creator()
    {
        public ActivityData createFromParcel(Parcel paramAnonymousParcel)
        {
            ActivityData localActivityData = new ActivityData();
            localActivityData.setYear(paramAnonymousParcel.readInt());
            localActivityData.setMonth(paramAnonymousParcel.readInt());
            localActivityData.setDay(paramAnonymousParcel.readInt());
            localActivityData.setHour(paramAnonymousParcel.readInt());
            localActivityData.setActivityValue(paramAnonymousParcel.readInt());
            localActivityData.setActivityType(paramAnonymousParcel.readString());
            return localActivityData;
        }

        /**
         *
         * @param paramAnonymousInt
         * @return
         */
        public ActivityData[] newArray(int paramAnonymousInt)
        {
            return new ActivityData[paramAnonymousInt];
        }
    };


    private String activityType;
    private int activityValue;
    private int day;
    private int hour;
    private int month;
    private int year;

    public int describeContents()
    {
        return 0;
    }

    public String getActivityType()
    {
        return this.activityType;
    }

    public int getActivityValue()
    {
        return this.activityValue;
    }

    public int getDay()
    {
        return this.day;
    }

    public int getHour()
    {
        return this.hour;
    }

    public int getMonth()
    {
        return this.month;
    }

    public int getYear()
    {
        return this.year;
    }

    public void setActivityType(String paramString)
    {
        this.activityType = paramString;
    }

    public void setActivityValue(int paramInt)
    {
        this.activityValue = paramInt;
    }

    public void setDay(int paramInt)
    {
        this.day = paramInt;
    }

    public void setHour(int paramInt)
    {
        this.hour = paramInt;
    }

    public void setMonth(int paramInt)
    {
        this.month = paramInt;
    }

    public void setYear(int paramInt)
    {
        this.year = paramInt;
    }

    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
        paramParcel.writeInt(this.year);
        paramParcel.writeInt(this.month);
        paramParcel.writeInt(this.day);
        paramParcel.writeInt(this.hour);
        paramParcel.writeInt(this.activityValue);
        paramParcel.writeString(this.activityType);
    }
}


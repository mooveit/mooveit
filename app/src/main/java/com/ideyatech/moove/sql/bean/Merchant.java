package com.ideyatech.moove.sql.bean;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class Merchant {


    public int id;
    public String name;
    public String mapsId;
    public String logoId;
    public String website;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMapsId() {
        return mapsId;
    }

    public void setMapsId(String mapsId) {
        this.mapsId = mapsId;
    }

    public String getLogoId() {
        return logoId;
    }

    public void setLogoId(String logoId) {
        this.logoId = logoId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

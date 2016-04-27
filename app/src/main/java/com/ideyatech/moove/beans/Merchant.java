package com.ideyatech.moove.beans;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class Merchant {

    private String name;
    private int logoId;
    private String website;

    public Merchant(int logoId, String name, String website) {
        this.name = name;
        this.logoId = logoId;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLogoId() {
        return logoId;
    }

    public void setLogoId(int logoId) {
        this.logoId = logoId;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

package com.ideyatech.moove.beans;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class Merchant {

    private String name;
    private String logoId;
    private String website;

    public Merchant(String name, String logoId, String website) {
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

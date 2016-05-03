package com.ideyatech.moove.ui.beans;


public class DashboardRowItem {

    /**
     *
     */
    private int imageId;
    private String value;
    private String rewardComment;
    private String unit;
    private int medalId;

    /**
     *
     * @param imageId
     * @param value
     * @param desc
     */
    public DashboardRowItem(int imageId, String value, String unit, int medalId, String desc) {
        this.imageId = imageId;
        this.value = value;
        this.rewardComment = desc;
        this.unit = unit;
        this.medalId = medalId;
    }

    public String getUnit() { return unit; }
    public void setUnit(String unit) { this.unit = unit; }
    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }
    public String getRewardComment() {
        return rewardComment;
    }
    public void setRewardComment(String rewardComment) {
        this.rewardComment = rewardComment;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public int getMedalId() { return medalId; }
    public void setMedalId(int medalId) { this.medalId = medalId; }

    @Override
    public String toString() {
        return value + "\n" + rewardComment;
    }
}
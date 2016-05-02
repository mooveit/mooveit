package com.ideyatech.moove.ui.beans;


public class DashboardRowItem {

    /**
     *
     */
    private int imageId;
    private String value;
    private String rewardComment;
    private String unit;

    /**
     *
     * @param imageId
     * @param value
     * @param desc
     */
    public DashboardRowItem(int imageId, String value, String unit, String desc) {
        this.imageId = imageId;
        this.value = value;
        this.rewardComment = desc;
        this.unit = unit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

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

    @Override
    public String toString() {
        return value + "\n" + rewardComment;
    }
}
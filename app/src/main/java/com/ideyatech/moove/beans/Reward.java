package com.ideyatech.moove.beans;


/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class Reward {

    private String name;
    private String merchant;
    private int imageId;
    private String description;
    private String expiration;
    private String mechanics;
    private int targetCalories;
    private int targetMoves;
    private int targetNumberOfMinutes;

    public Reward(int imageId,
                  String name,
                  String merchant,
                  String description,
                  String expiration
                  //String mechanics
                  //int targetCalories,
                  //int targetMoves,
                  //int targetNumberOfMinutes
                  )
    {
        this.name = name;
        this.merchant = merchant;
        this.imageId = imageId;
        this.description = description;
        this.expiration = expiration;
        this.mechanics = mechanics;
//        this.targetCalories = targetCalories;
//        this.targetMoves = targetMoves;
//        this.targetNumberOfMinutes = targetNumberOfMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExpiration() {
        return expiration;
    }

    public void setExpiration(String expiration) {
        this.expiration = expiration;
    }

    public String getMechanics() {
        return mechanics;
    }

    public void setMechanics(String mechanics) {
        this.mechanics = mechanics;
    }

    public int getTargetCalories() {
        return targetCalories;
    }

    public void setTargetCalories(int targetCalories) {
        this.targetCalories = targetCalories;
    }

    public int getTargetMoves() {
        return targetMoves;
    }

    public void setTargetMoves(int targetMoves) {
        this.targetMoves = targetMoves;
    }

    public int getTargetNumberOfMinutes() {
        return targetNumberOfMinutes;
    }

    public void setTargetNumberOfMinutes(int targetNumberOfMinutes) {
        this.targetNumberOfMinutes = targetNumberOfMinutes;
    }
}

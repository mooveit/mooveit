package com.ideyatech.moove.beans;

import java.util.Date;

/**
 * Created by IDT-Maynelson-PC on 4/22/2016.
 */
public class Reward {

    private String name;
    private String imageId;
    private String description;
    private Date expiration;
    private String mechanics;
    private int targetCalories;
    private int targetMoves;
    private int targetNumberOfMinutes;

    public Reward(String name,
                  String imageId,
                  String description,
                  Date expiration,
                  String mechanics,
                  int targetCalories,
                  int targetMoves,
                  int targetNumberOfMinutes)
    {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
        this.expiration = expiration;
        this.mechanics = mechanics;
        this.targetCalories = targetCalories;
        this.targetMoves = targetMoves;
        this.targetNumberOfMinutes = targetNumberOfMinutes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiration() {
        return expiration;
    }

    public void setExpiration(Date expiration) {
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

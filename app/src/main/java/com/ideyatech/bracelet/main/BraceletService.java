package com.ideyatech.bracelet.main;

/**
 * Created by IDT-Maynelson-PC on 4/21/2016.
 */
public class BraceletService {

    public String value;
    public String comment;
    public String image;

    /**
     *
     * @param value
     * @param comment
     * @param image
     */
    public BraceletService(String value, String comment, String image){
        this.value = value;
        this.comment = comment;
        this.image = image;
    }
}

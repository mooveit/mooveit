package com.ideyatech.moove.sql.bean;

import java.util.Date;

public class Reward {

    public String id;
    public String name;
    public String merchant;
    public String imageid;
    public int claimed;
    public int rewardflag;
    public String mechanics;
    public int targetcalories;
    public int  targetsleep;
    public int targetmove;
    public int targetactive;
    public Date promostart;
    public Date promoend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getImageid() {
        return imageid;
    }

    public void setImageid(String imageid) {
        this.imageid = imageid;
    }

    public int getClaimed() {
        return claimed;
    }

    public void setClaimed(int claimed) {
        this.claimed = claimed;
    }

    public int getRewardflag() {
        return rewardflag;
    }

    public void setRewardflag(int rewardflag) {
        this.rewardflag = rewardflag;
    }

    public String getMechanics() {
        return mechanics;
    }

    public void setMechanics(String mechanics) {
        this.mechanics = mechanics;
    }

    public int getTargetcalories() {
        return targetcalories;
    }

    public void setTargetcalories(int targetcalories) {
        this.targetcalories = targetcalories;
    }

    public int getTargetsleep() {
        return targetsleep;
    }

    public void setTargetsleep(int targetsleep) {
        this.targetsleep = targetsleep;
    }

    public int getTargetmove() {
        return targetmove;
    }

    public void setTargetmove(int targetmove) {
        this.targetmove = targetmove;
    }

    public int getTargetactive() {
        return targetactive;
    }

    public void setTargetactive(int targetactive) {
        this.targetactive = targetactive;
    }

    public Date getPromostart() {
        return promostart;
    }

    public void setPromostart(Date promostart) {
        this.promostart = promostart;
    }

    public Date getPromoend() {
        return promoend;
    }

    public void setPromoend(Date promoend) {
        this.promoend = promoend;
    }
}

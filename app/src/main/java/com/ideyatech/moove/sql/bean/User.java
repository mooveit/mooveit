package com.ideyatech.moove.sql.bean;

/**
 * Created by IDT-Maynelson-PC on 4/25/2016.
 */
public class User {

    public String id;
    public String username;
    public String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

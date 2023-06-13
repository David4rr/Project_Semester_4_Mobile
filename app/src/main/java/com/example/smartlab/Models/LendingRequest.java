package com.example.smartlab.Models;

import com.google.gson.annotations.SerializedName;

public class LendingRequest {
    @SerializedName("user_id")
    private String user;
    @SerializedName("lending_date")
    private String lending_date;
    @SerializedName("return_date")
    private String return_date;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getLending_date() {
        return lending_date;
    }

    public void setLending_date(String lending_date) {
        this.lending_date = lending_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}

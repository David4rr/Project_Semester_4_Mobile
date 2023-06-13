package com.example.smartlab.Models;

import com.google.gson.annotations.SerializedName;

public class LendingResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private LendingRequest data;

    public LendingResponse(String success, String message, LendingRequest data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LendingRequest getData() {
        return data;
    }

    public void setData(LendingRequest data) {
        this.data = data;
    }
}

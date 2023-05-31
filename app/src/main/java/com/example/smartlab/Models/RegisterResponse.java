package com.example.smartlab.Models;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private RegisterRequest data;

    public RegisterResponse(String success, String message, RegisterRequest data) {
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

    public RegisterRequest getData() {
        return data;
    }

    public void setData(RegisterRequest data) {
        this.data = data;
    }
}

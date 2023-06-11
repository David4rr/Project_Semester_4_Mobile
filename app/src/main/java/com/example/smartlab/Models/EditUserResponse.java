package com.example.smartlab.Models;

import com.google.gson.annotations.SerializedName;

public class EditUserResponse {
    @SerializedName("success")
    private String success;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private EditUserRequest data;

    public EditUserResponse(String success, String message, EditUserRequest data) {
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

    public EditUserRequest getData() {
        return data;
    }

    public void setData(EditUserRequest data) {
        this.data = data;
    }
}

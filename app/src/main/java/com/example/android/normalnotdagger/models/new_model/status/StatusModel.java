package com.example.android.normalnotdagger.models.new_model.status;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class StatusModel {
    @SerializedName("status")
    @Expose
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

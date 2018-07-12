package com.example.manjil.sriyogapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Dell on 4/20/2018.
 */

public class Model_new_iding {
    @SerializedName("id")
    private String id;

    public Model_new_iding() {
    }

    public Model_new_iding(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

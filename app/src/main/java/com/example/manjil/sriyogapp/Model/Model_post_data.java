package com.example.manjil.sriyogapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Razu on 1/8/2018.
 */

public class Model_post_data {
    @SerializedName("name")
    private String name;
    @SerializedName("phone")
    private String phone;
    @SerializedName("address")
    private String address;
    @SerializedName("sub")
    private String sub;
    @SerializedName("body")
    private String body;
    @SerializedName("ack")
    private String ack;

    public Model_post_data(String name, String phone, String address, String sub, String body, String ack) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.sub = sub;
        this.body = body;
        this.ack = ack;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAck() {
        return ack;
    }

    public void setAck(String ack) {
        this.ack = ack;
    }
}

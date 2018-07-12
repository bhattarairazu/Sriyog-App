package com.example.manjil.sriyogapp.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Razu on 12/30/2017.
 */

public class Model_notice_array {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("name")
    private String name;
    @SerializedName("email")
    private String email;
    @SerializedName("phone")
    private String phone;
    @SerializedName("phone1")
    private String phone1;
    @SerializedName("address")
    private String address;
    @SerializedName("post")
    private String post;
    @SerializedName("mob")
    private String mob;
    @SerializedName("office")
    private String office;
    @SerializedName("content")
    private String content;
    @SerializedName("ward_no")
    private String ward_no;
    @SerializedName("description")
    private String description;
    @SerializedName("image")
    private String image;
    @SerializedName("date")
    private String date;
    @SerializedName("file")
    private String file;
    @SerializedName("about")
    private String about;
    @SerializedName("latitude")
    private String latitude;
    @SerializedName("longitude")
    private String longitude;
    @SerializedName("iframe")
    private String iframe;
    @SerializedName("type")
    private int type;

    @SerializedName("place")
    private String place;

    @SerializedName("category")
    private String category;

    public Model_notice_array() {

    }

    public Model_notice_array(String id, String title, String name, String email, String phone, String phone1, String address, String post, String mob, String office, String content, String ward_no, String description, String image, String date, String file, String about, String latitude, String longitude, String iframe, int type,String place,String category) {
        this.id = id;
        this.title = title;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.phone1 = phone1;
        this.address = address;
        this.post = post;
        this.mob = mob;
        this.office = office;
        this.content = content;
        this.ward_no = ward_no;
        this.description = description;
        this.image = image;
        this.date = date;
        this.file = file;
        this.about = about;
        this.latitude = latitude;
        this.longitude = longitude;
        this.iframe = iframe;
        this.type = type;
        this.place =place;
        this.category=category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getMob() {
        return mob;
    }

    public void setMob(String mob) {
        this.mob = mob;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWard_no() {
        return ward_no;
    }

    public void setWard_no(String ward_no) {
        this.ward_no = ward_no;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getIframe() {
        return iframe;
    }

    public void setIframe(String iframe) {
        this.iframe = iframe;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

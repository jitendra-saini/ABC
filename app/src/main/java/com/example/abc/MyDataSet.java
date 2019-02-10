package com.example.abc;

public class MyDataSet {

    int profile_image;
    String f_name,post_details;

    public MyDataSet(int profile_image, String f_name, String post_details) {
        this.profile_image = profile_image;
        this.f_name = f_name;
        this.post_details = post_details;
    }

    public int getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(int profile_image) {
        this.profile_image = profile_image;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getPost_details() {
        return post_details;
    }

    public void setPost_details(String post_details) {
        this.post_details = post_details;
    }
}

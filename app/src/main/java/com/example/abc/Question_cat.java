package com.example.abc;

public class Question_cat {

    String cat;
    int cat_image;

    public Question_cat(String cat, int cat_image) {
        this.cat = cat;
        this.cat_image = cat_image;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public int getCat_image() {
        return cat_image;
    }

    public void setCat_image(int cat_image) {
        this.cat_image = cat_image;
    }
}

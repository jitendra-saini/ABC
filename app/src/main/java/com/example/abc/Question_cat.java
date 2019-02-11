package com.example.abc;

import java.io.Serializable;

public class Question_cat implements Serializable {

    String cat;

    boolean isSelected =false;

    public Question_cat(String cat) {
        this.cat = cat;

    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }


    public void setSelected(boolean selected) {
        isSelected = selected;
    }


    public boolean isSelected() {
        return isSelected;
    }


    @Override
    public String toString() {
        return "Question_cat{" +
                "cat='" + cat + '\'' +

                ", isSelected=" + isSelected +
                '}';
    }
}

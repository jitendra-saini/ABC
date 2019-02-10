package com.example.abc;

class MyItemDataSet {

    int artist_image;
    String artist_name;

    public MyItemDataSet(int artist_image, String artist_name) {
        this.artist_image = artist_image;
        this.artist_name = artist_name;
    }

    public int getArtist_image() {
        return artist_image;
    }

    public void setArtist_image(int artist_image) {
        this.artist_image = artist_image;
    }

    public String getArtist_name() {
        return artist_name;
    }

    public void setArtist_name(String artist_name) {
        this.artist_name = artist_name;
    }
}

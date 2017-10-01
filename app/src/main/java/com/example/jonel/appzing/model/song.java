package com.example.jonel.appzing.model;

/**
 * Created by jonel on 10/1/2017.
 */

public class song {
    private String song, artist;
    private int icon;

    public song(String song, String artist, int icon) {
        this.song = song;
        this.artist = artist;
        this.icon = icon;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}

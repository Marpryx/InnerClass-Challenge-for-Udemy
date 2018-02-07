package com.prykhodko;

public class Song {
    private String songTitle;
    private double durations;

    public Song(String title, double durations) {
        this.songTitle = title;
        this.durations = durations;
    }

    public String getTitle() {
        return songTitle;
    }

    public double getDurations() {
        return durations;
    }

    @Override
    public String toString() {
        return this.songTitle + ": " + this.durations;
    }
}

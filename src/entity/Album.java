package entity;

import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    private String genre;

    private final Song[] songs;

    public Album(String name, String artist, String genre, Song[] songs) {
        this.name = name;
        this.artist = artist;
        this.genre = genre;
        this.songs = songs;
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getGenre() {
        return genre;
    }

    public Song[] getSongs() {
        return songs;
    }
}

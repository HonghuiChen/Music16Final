package entity;

import java.util.ArrayList;

public class Song {
private String name;
    private String artist;
    private String album;
    private String url;

    private ArrayList<String> comments;

    public Song(String name, String artist, String album, String url) {
        this.name = name;
        this.artist = artist;
        this.album = album;
        this.url = url;
        this.comments = new ArrayList<String>();
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public String getAlbum() {
        return album;
    }

    public String getUrl() {
        return url;
    }

    public void addComments(String comment){
        this.comments.add(comment);
    }
}

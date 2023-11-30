package entity;

import java.util.ArrayList;

public class Song {
private final String name;
    private final String artist;
    private final String album;
    private final String url;

    private final ArrayList<String> comments;

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
    public ArrayList<String> getComments(){
        return comments;
    }
}

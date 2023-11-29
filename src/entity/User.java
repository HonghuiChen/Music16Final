package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private LocalDateTime creationTime;
    private ArrayList<String> genrePreference;
    private ArrayList<String> FavoriteArtist;
    private ArrayList<String> FavoriteSongs;

    public User(String name, String password, LocalDateTime ltd) {
        this.username = name;
        this.password = password;
        this.creationTime = ltd;
}

    public String getPassword() {
        return password;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getUsername() {
        return username;
    }


    public ArrayList<Song> getFavoriteSongs(){ return FavoriteSongs;}

    public ArrayList<String> getFavoriteArist(){ return FavoriteArist;}

    public ArrayList<String> getGenrePreference() { return genrePreference; }
}

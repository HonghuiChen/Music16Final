package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private LocalDateTime creationTime;
    private ArrayList<String> genrePreference;
    private ArrayList<String> FavoriteArist;
    private ArrayList<Song> FavoriteSongs;
    private ArrayList<User> Followers;
    private ArrayList<User> Follow;


    public User(String name, String password) {
        this.username = name;
        this.password = password;
}

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Object getCreationTime() {
        return creationTime;
    }
}

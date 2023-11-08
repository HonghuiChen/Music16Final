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
}

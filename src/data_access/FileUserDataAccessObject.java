package data_access;

import entity.User;
import entity.Song;
import entity.UserFactory;
import use_case.login.LoginUserDataAccessInterface;
import use_case.signup.SignupUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Data Access Object for primary user data: username, password, creation time.
// Most of this is from CACoding.

public class FileUserDataAccessObject implements SignupUserDataAccessInterface, LoginUserDataAccessInterface {

    private final File csvFile;

    private final File currUserFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, User> accounts = new HashMap<>();

    private UserFactory userFactory;

    public FileUserDataAccessObject(String csvPath, UserFactory userFactory) throws IOException {
        this.userFactory = userFactory;

        csvFile = new File(csvPath);
        currUserFile = new File("./currentUser.txt");
        headers.put("username", 0);
        headers.put("password", 1);
        headers.put("creation_time", 2);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("username,password,creation_time");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String username = String.valueOf(col[headers.get("username")]);
                    String password = String.valueOf(col[headers.get("password")]);
                    String creationTimeText = String.valueOf(col[headers.get("creation_time")]);
                    LocalDateTime ldt = LocalDateTime.parse(creationTimeText);
                    User user = userFactory.create(username, password, ldt);
                    accounts.put(username, user);
                }
            }
        }
    }

    public void save(User user) {
        accounts.put(user.getUsername(), user);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s",
                        user.getUsername(), user.getPassword(), user.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // get user by username
    public User get(String username) {
        return accounts.get(username);
    }

    @Override
    public void storeCurrUser(String username) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(currUserFile));
            writer.flush();
            writer.write(username);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String readCurrUser(String fname) throws FileNotFoundException {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fname));
            return reader.readLine();
        } catch (IOException e) {
            throw new FileNotFoundException();
        }
    }

    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }


//    public boolean existsByTracks(String username, String song){
//        User user = get(username);
//        ArrayList<Song> songs = user.getFavoriteSongs();
//        return songs.contains(song);
//    }
//
//    public boolean existsByArtists(String username, String artist){
//        User user = get(username);
//        ArrayList<String> artists = user.getFavoriteArist();
//        return artists.contains(artist);
//    }
  
    public boolean haveGenre(String username, String genre) {
        User user = get(username);
        ArrayList<String> genres = user.getGenrePreference();
        return genres.contains(genre);
    }
}

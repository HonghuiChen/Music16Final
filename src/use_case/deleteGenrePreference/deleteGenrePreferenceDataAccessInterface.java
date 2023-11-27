package use_case.deleteGenrePreference;

import entity.User;

import java.io.FileNotFoundException;

public interface deleteGenrePreferenceDataAccessInterface {
    boolean haveGenre(String username, String genre);

    public User get(String username);

    String readCurrUser(String fname) throws FileNotFoundException;
}

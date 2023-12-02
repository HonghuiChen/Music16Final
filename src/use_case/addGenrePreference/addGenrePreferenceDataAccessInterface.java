package use_case.addGenrePreference;

import entity.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface addGenrePreferenceDataAccessInterface {
    boolean haveGenre(String username, String genre);

    public User get(String username);

    String readCurrUser(String fname) throws FileNotFoundException;
}


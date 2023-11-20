package use_case.addGenrePreference;

import entity.User;

public interface addGenrePreferenceDataAccessInterface {
    boolean haveGenre(String username, String genre);

    public User get(String username);

    void addGenre(String genre);
}


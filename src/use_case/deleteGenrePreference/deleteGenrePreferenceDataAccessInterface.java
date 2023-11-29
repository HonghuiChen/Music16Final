package use_case.deleteGenrePreference;

import entity.User;

public interface deleteGenrePreferenceDataAccessInterface {
    boolean haveGenre(String username, String genre);

    public User get(String username);

    void deleteGenre(String genre);

    String readCurrUser(String fname);
}

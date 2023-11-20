package use_case.LikeArtists;

import entity.User;

public interface LikeArtistsDataAccessInterface {
    boolean existsByArtists(String username, String song);
    String readCurrUser(String fname);
    User get(String username);
}

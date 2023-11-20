package use_case.LikeArtists;

import entity.User;

public interface LikeArtistsDataAccessInterface {
    boolean existsByArtists(String username, String song);
    User get(String username);
}

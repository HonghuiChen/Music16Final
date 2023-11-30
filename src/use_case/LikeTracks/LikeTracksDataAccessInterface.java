package use_case.LikeTracks;

import entity.User;

public interface LikeTracksDataAccessInterface {
    boolean existsByTracks(String username, String song);
    String readCurrUser(String fname);
    User get(String username);
}


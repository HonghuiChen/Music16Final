package use_case.LikeTracks;

import entity.User;

public interface LikeTracksDataAccessInterface {
    boolean existsByTracks(String username, String song); // not implemented yet
    User get(String username);
}


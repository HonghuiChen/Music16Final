package use_case.LikeArtists;

public interface LikeArtistsOutputBoundary {
    void prepareLikeSuccessView(LikeArtistsOutputData artist);
    void prepareUnlikeSuccessView(LikeArtistsOutputData artist);
    void prepareFailView(String error);
}

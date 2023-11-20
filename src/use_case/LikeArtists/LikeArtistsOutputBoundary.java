package use_case.LikeArtists;

public interface LikeArtistsOutputBoundary {
    void prepareLikeSuccessView(LikeArtistsOutputData song);
    void prepareUnlikeSuccessView(LikeArtistsOutputData song);
    void prepareFailView(String error);
}

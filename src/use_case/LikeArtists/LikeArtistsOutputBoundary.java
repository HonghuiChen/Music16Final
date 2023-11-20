package use_case.LikeArtists;

public interface LikeArtistsOutputBoundary {
    void prepareSuccessView(LikeArtistsOutputData song);
    void prepareFailView(String error);
}

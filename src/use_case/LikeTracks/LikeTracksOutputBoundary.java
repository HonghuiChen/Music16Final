package use_case.LikeTracks;


public interface LikeTracksOutputBoundary {
    void prepareSuccessView(LikeTracksOutputData song);
    void prepareFailView(String error);
}

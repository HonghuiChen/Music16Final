package use_case.LikeTracks;


public interface LikeTracksOutputBoundary {
    void prepareLikeSuccessView(LikeTracksOutputData song);
    void prepareUnlikeSuccessView(LikeTracksOutputData song);
    void prepareFailView(String error);
}

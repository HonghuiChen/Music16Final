package use_case.LikeTracks;

import entity.User;

public class LikeTracksInteractor implements LikeTracksInputBoundary{
    final LikeTracksDataAccessInterface likeTracksDataAccessObject;
    final LikeTracksOutputBoundary likePresenter;

    public LikeTracksInteractor(LikeTracksDataAccessInterface likeTracksDataAccessInterface,
                                LikeTracksOutputBoundary likeTracksOutputBoundary){
        this.likeTracksDataAccessObject = likeTracksDataAccessInterface;
        this.likePresenter = likeTracksOutputBoundary;
    }

    @Override
    public void like(LikeTracksInputData likeTracksInputData) {
        String username = likeTracksDataAccessObject.readCurrUser("currentUser.txt");
        if (likeTracksDataAccessObject.existsByTracks(username, likeTracksInputData.getSong())) {
            likePresenter.prepareFailView("You already liked this song");
        } else {
            User user = likeTracksDataAccessObject.get(likeTracksInputData.getSong());
            LikeTracksOutputData likeTracksOutputData = new LikeTracksOutputData(username, false);
            likePresenter.prepareLikeSuccessView(likeTracksOutputData);
        }
    }
    @Override
    public void unlike(LikeTracksInputData likeTracksInputData) {
        String username = likeTracksDataAccessObject.readCurrUser("currentUser.txt");
        User user = likeTracksDataAccessObject.get(likeTracksInputData.getSong());
        LikeTracksOutputData likeTracksOutputData = new LikeTracksOutputData(username, false);
        likePresenter.prepareUnlikeSuccessView(likeTracksOutputData);
    }


}

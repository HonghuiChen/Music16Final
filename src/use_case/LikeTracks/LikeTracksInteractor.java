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
        if (likeTracksDataAccessObject.existsByTracks(user.getusername(), LikeTracksInputData.getSong())) {
            likePresenter.prepareFailView("You already liked this song");
        } else {
            User user = likeTracksDataAccessObject.get(likeTracksInputData.getSong());
            LikeTracksOutputData likeTracksOutputData = new LikeTracksOutputData(user.getUsername(), false);
            likePresenter.prepareSuccessView(likeTracksOutputData);
        }
    }
    @Override
    public void unlike(LikeTracksInputData likeTracksInputData) {
        User user = likeTracksDataAccessObject.get(likeTracksInputData.getSong());
        LikeTracksOutputData likeTracksOutputData = new LikeTracksOutputData(user.getUsername(), false);
        likePresenter.prepareSuccessView(likeTracksOutputData);
    }


}

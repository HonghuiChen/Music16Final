package use_case.LikeArtists;

import entity.User;

public class LikeArtistsInteractor implements LikeArtistsInputBoundary {
    final LikeArtistsDataAccessInterface likeArtistsDataAccessObject;
    final LikeArtistsOutputBoundary likePresenter;

    public LikeArtistsInteractor(LikeArtistsDataAccessInterface likeArtistsDataAccessInterface,
                                LikeArtistsOutputBoundary likeArtistsOutputBoundary){
        this.likeArtistsDataAccessObject = likeArtistsDataAccessInterface;
        this.likePresenter = likeArtistsOutputBoundary;
    }

    @Override
    public void like(LikeArtistsInputData likeArtistsInputData) {
        if (likeArtistsDataAccessObject.existsByArtists(user.getUsername(), likeArtistsInputData.getArtist())) {
            likePresenter.prepareFailView("You already liked this artist");
        } else {
            User user = likeArtistsDataAccessObject.get(likeArtistsInputData.getArtist());
            LikeArtistsOutputData likeArtistsOutputData = new LikeArtistsOutputData(user.getUsername(), false);
            likePresenter.prepareSuccessView(likeArtistsOutputData);
        }
    }

    @Override
    public void unlike(LikeArtistsInputData likeArtistsInputData) {
        User user = likeArtistsDataAccessObject.get(likeArtistsInputData.getArtist());
        LikeArtistsOutputData likeArtistsOutputData = new LikeArtistsOutputData(user.getUsername(), false);
        likePresenter.prepareSuccessView(likeArtistsOutputData);
    }
}


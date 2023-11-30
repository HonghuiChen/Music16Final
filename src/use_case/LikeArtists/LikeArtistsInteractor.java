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
        String username = likeArtistsDataAccessObject.readCurrUser("currentUser.txt");
        if (likeArtistsDataAccessObject.existsByArtists(username, likeArtistsInputData.getArtist())) {
            likePresenter.prepareFailView("You already liked this artist");
        } else {
            User user = likeArtistsDataAccessObject.get(likeArtistsInputData.getArtist());
            LikeArtistsOutputData likeArtistsOutputData = new LikeArtistsOutputData(username, false);
            likePresenter.prepareLikeSuccessView(likeArtistsOutputData);
        }
    }

    @Override
    public void unlike(LikeArtistsInputData likeArtistsInputData) {
        String username = likeArtistsDataAccessObject.readCurrUser("currentUser.txt");
        User user = likeArtistsDataAccessObject.get(likeArtistsInputData.getArtist());
        LikeArtistsOutputData likeArtistsOutputData = new LikeArtistsOutputData(username, false);
        likePresenter.prepareUnlikeSuccessView(likeArtistsOutputData);
    }
}


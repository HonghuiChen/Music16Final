package interface_adapter.LikeArtists;

import interface_adapter.ViewManagerModel;
import interface_adapter.LikeArtists.LikeArtistsViewModel;
import use_case.LikeArtists.LikeArtistsOutputBoundary;
import use_case.LikeArtists.LikeArtistsOutputData;

public class LikeArtistsPresenter implements LikeArtistsOutputBoundary {
    private final LikeArtistsViewModel likeArtistsViewModel;
    private ViewManagerModel viewManagerModel;

    public LikeArtistsPresenter(ViewManagerModel viewManagerModel, LikeArtistsViewModel likeArtistsViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.likeArtistsViewModel = likeArtistsViewModel;
    }

    @Override
    public void prepareLikeSuccessView(LikeArtistsViewModel artist){
        // implemented later
    }

    @Override
    public void prepareUnlikeSuccessView(LikeArtistsViewModel artist){
        // implemented later
    }

    @Override
    public void prepareFailView(LikeArtistsViewModel artist){
        // implemented later
    }
}

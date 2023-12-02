package interface_adapter.LikeArtists;

import interface_adapter.ViewManagerModel;
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
    public void prepareLikeSuccessView(LikeArtistsOutputData artist){
        LikeArtistsState likeArtistsState = likeArtistsViewModel.getState(); // implement getState
        likeArtistsState.likeArtist(artist.getArtists()); // implement getArtists??
        this.viewManagerModel.setActiveView(likeArtistsViewModel.getViewName()); // implement getViewName
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareUnlikeSuccessView(LikeArtistsOutputData artist){
        LikeArtistsState likeArtistsState = likeArtistsViewModel.getState();
        likeArtistsState.unlikeArtist(artist.getArtists());
        this.viewManagerModel.setActiveView(likeArtistsViewModel.getViewName()); // implement getViewName
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error){
        LikeArtistsState likeArtistsState = likeArtistsViewModel.getState();
        likeArtistsState.likeArtistError(error); // implement likeError??
        likeArtistsViewModel.firePropertyChanged();
    }
}

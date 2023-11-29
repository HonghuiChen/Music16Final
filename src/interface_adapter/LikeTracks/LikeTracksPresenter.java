package interface_adapter.LikeTracks;

import interface_adapter.LikeArtists.LikeArtistsViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.LikeTracks.LikeTracksViewModel;
import use_case.LikeArtists.LikeArtistsOutputBoundary;
import use_case.LikeTracks.LikeTracksOutputBoundary;
import use_case.LikeTracks.LikeTracksOutputData;

public class LikeTracksPresenter implements LikeTracksOutputBoundary {
    private final LikeTracksViewModel likeTracksViewModel;
    private ViewManagerModel viewManagerModel;

    public LikeTracksPresenter(ViewManagerModel viewManagerModel, LikeTracksViewModel likeTracksViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.likeTracksViewModel = likeTracksViewModel;
    }

    @Override
    public void prepareLikeSuccessView(LikeTracksOutputData track){
        LikeTracksState likeTracksState = likeTracksViewModel.getState(); // implement getState
        likeTracksState.likeTrack(track.getSong()); // implement getTrack
        this.viewManagerModel.setActiveView(likeTracksViewModel.getViewName()); // implement getViewName
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareUnlikeSuccessView(LikeTracksOutputData track){
        LikeTracksState likeTracksState = likeTracksViewModel.getState(); // implement getState
        likeTracksState.unlikeTrack(track.getSong()); // implement getTrack
        this.viewManagerModel.setActiveView(likeTracksViewModel.getViewName()); // implement getViewName
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error){
        LikeTracksState likeTracksState = likeTracksViewModel.getState();
        likeTracksState.likeTrackError(error); // implement likeError
        likeTracksViewModel.firePropertyChanged();
    }
}

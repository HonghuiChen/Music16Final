package interface_adapter.LikeTracks;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.LikeTracks.LikeTracksOutputBoundary;
import use_case.LikeTracks.LikeTracksOutputData;
import java.util.Objects;

public class LikeTracksPresenterTest {
    LikeTracksViewModel likeTracksViewModel;
    ViewManagerModel viewManagerModel;
    LikeTracksOutputBoundary likeTracksPresenter;
    LikeTracksOutputData likeTracksOutputData;

    @BeforeEach
    void setUp(){
        likeTracksViewModel = new LikeTracksViewModel();
        LikeTracksState exampleState = likeTracksViewModel.getState();
        exampleState.likeTrack("Welcome To New York");
        exampleState.unlikeTrack("Welcome To New York");
        likeTracksViewModel.setState(exampleState);
        viewManagerModel = new ViewManagerModel();
        likeTracksPresenter = new LikeTracksPresenter(viewManagerModel, likeTracksViewModel);
        likeTracksOutputData = new LikeTracksOutputData("Welcome To New York" , false);
    }

    @Test
    void Successtest(){
        likeTracksPresenter.prepareLikeSuccessView(likeTracksOutputData);
        assert Objects.equals(viewManagerModel.getActiveView(), "Like");
        assert Objects.equals(likeTracksViewModel.getState().getTrack(), "Welcome To New York" );
        assert Objects.equals(likeTracksViewModel.getState().getLikeTrackError(), null);
    }
}



package interface_adapter.LikeArtists;

import interface_adapter.ViewManagerModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.LikeArtists.LikeArtistsOutputBoundary;
import use_case.LikeArtists.LikeArtistsOutputData;

import java.util.Objects;

public class LikeArtistsPresenterTest {
    LikeArtistsViewModel likeArtistsViewModel;
    ViewManagerModel viewManagerModel;
    LikeArtistsOutputBoundary likeArtistsPresenter;
    LikeArtistsOutputData likeArtistsOutputData;

    @BeforeEach
    void setUp(){
        likeArtistsViewModel = new LikeArtistsViewModel();
        LikeArtistsState exampleState = likeArtistsViewModel.getState();
        exampleState.likeArtist("Coldplay");
        exampleState.unlikeArtist("Coldplay");
        likeArtistsViewModel.setState(exampleState);
        viewManagerModel = new ViewManagerModel();
        likeArtistsPresenter = new LikeArtistsPresenter(viewManagerModel, likeArtistsViewModel);
        likeArtistsOutputData = new LikeArtistsOutputData("Coldplay", false);
    }

    @Test
    void SuccessTest(){
        likeArtistsPresenter.prepareLikeSuccessView(likeArtistsOutputData);
        assert Objects.equals(viewManagerModel.getActiveView(), "Like");
        assert Objects.equals(likeArtistsViewModel.getState().getArtists(), "Coldplay");
        assert Objects.equals(likeArtistsViewModel.getState().getLikeArtistsError(), null);
    }

    @Test
    void SuccessTest2(){
       likeArtistsPresenter.prepareUnlikeSuccessView(likeArtistsOutputData);
       assert Objects.equals(viewManagerModel.getActiveView(), "Like");
       assert Objects.equals(likeArtistsViewModel.getState().getArtists(), null);
       assert Objects.equals(likeArtistsViewModel.getState().getLikeArtistsError(), null);
    }

//    @Test
//    void FailTest(){
//        likeArtistsPresenter.prepareFailView("You already liked this artist");
//        assert Objects.equals(viewManagerModel.getActiveView(), "Like");
//        assert Objects.equals(likeArtistsViewModel.getState().getArtists(), "Coldplay");
//        assert Objects.equals(likeArtistsViewModel.getState().getLikeArtistsError(), "Coldplay");
//    }

}

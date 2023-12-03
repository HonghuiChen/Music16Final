package interface_adapter.SearchArtist;

import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenState;
import interface_adapter.homeScreen.HomeScreenViewModel;
import use_case.SearchArtist.SearchArtistInputData;
import use_case.SearchArtist.SearchArtistOutputBoundary;
import use_case.SearchArtist.SearchArtistOutputData;

import java.util.ArrayList;

public class SearchArtistPresenter implements SearchArtistOutputBoundary {

    private final HomeScreenViewModel homeScreenViewModel;

    private ViewManagerModel viewManagerModel;

    public SearchArtistPresenter(ViewManagerModel viewManagerModel, HomeScreenViewModel homeScreenViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeScreenViewModel = homeScreenViewModel;
    }

    public SearchArtistPresenter(HomeScreenViewModel homeScreenViewModel) {
        this.homeScreenViewModel = homeScreenViewModel;
    }


    @Override
    public void prepareSuccessView(SearchArtistOutputData artistInfo) {
        HomeScreenState homeScreenState = homeScreenViewModel.getState();
        homeScreenState.setOutput(artistInfo.getOutput());
        this.homeScreenViewModel.setState(homeScreenState);
        homeScreenViewModel.firePropertyChanged("searchArtists");

    }

    @Override
    public void prepareFailView(String error) {
        HomeScreenState homeScreenState = homeScreenViewModel.getState();
        ArrayList<String> errorlist = new ArrayList<>();
        errorlist.add(error);
        homeScreenState.setOutput(errorlist);

        this.homeScreenViewModel.setState(homeScreenState);
        homeScreenViewModel.firePropertyChanged("searchArtists");
    }


}

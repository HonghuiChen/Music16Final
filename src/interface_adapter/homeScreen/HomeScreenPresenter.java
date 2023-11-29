package interface_adapter.homeScreen;

import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenState;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.login.LoginViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;
import use_case.SearchTrack.SearchTrackOutputBoundary;
import use_case.SearchTrack.SearchTrackOutputData;

public class HomeScreenPresenter implements SearchTrackOutputBoundary {
    private final HomeScreenViewModel homeScreenViewModel;
    private ViewManagerModel viewManagerModel;
    private HomeScreenState homeScreenState;

    public HomeScreenPresenter(ViewManagerModel viewManagerModel,
                               HomeScreenViewModel homeScreenViewModel,
                               LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeScreenViewModel = homeScreenViewModel;
        this.homeScreenState = homeScreenViewModel.getState();
    }

    @Override
    public void prepareSuccessView(SearchTrackOutputData results) {
        HomeScreenState homeScreenState = homeScreenViewModel.getState();
        homeScreenState.setOutput(results.getResults());
        this.homeScreenViewModel.setState(homeScreenState);
        this.homeScreenViewModel.firePropertyChanged("searchTracks");

        this.viewManagerModel.setActiveView(homeScreenViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    public void prepareFailView(String error) {
        HomeScreenState homeScreenState = homeScreenViewModel.getState();
        homeScreenState.setError(error);
        this.homeScreenViewModel.setState(homeScreenState);
        this.homeScreenViewModel.firePropertyChanged("SearchTrackError");

        this.viewManagerModel.setActiveView(homeScreenViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}

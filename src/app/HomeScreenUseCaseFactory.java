package app;

import interface_adapter.SearchArtist.SearchArtistController;
import interface_adapter.SearchArtist.SearchArtistPresenter;
import interface_adapter.SearchTrack.SearchTrackController;
import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenPresenter;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.homeScreen.LogoutController;
import interface_adapter.homeScreen.LogoutPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.SearchArtist.SearchArtistInputBoundary;
import use_case.SearchArtist.SearchArtistInteractor;
import use_case.SearchArtist.SearchArtistOutputBoundary;
import use_case.SearchTrack.SearchTrackInputBoundary;
import use_case.SearchTrack.SearchTrackInteractor;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import view.HomeScreenView;

import javax.swing.*;
import java.io.IOException;

public class HomeScreenUseCaseFactory {

    /** Prevent instantiation. */
    private HomeScreenUseCaseFactory() {}

    public static HomeScreenView create(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            HomeScreenViewModel homeScreenViewModel) {

        try {
            SearchTrackController searchTrackController = createSearchTrackController(viewManagerModel, loginViewModel, homeScreenViewModel);
            SearchArtistController searchArtistController = createSearchArtistUseCase(viewManagerModel, homeScreenViewModel);
            LogoutController logoutController = createLogoutController(viewManagerModel, loginViewModel, homeScreenViewModel);
            return new HomeScreenView(homeScreenViewModel, searchTrackController, searchArtistController, logoutController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "HS Factory Error: " + e.getMessage());
        }

        return null;
    }

    //TODO Create all the necessary controllers here
    private static SearchTrackController createSearchTrackController(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            HomeScreenViewModel homeScreenViewModel) throws IOException {

        // Notice how we pass this method's parameters to the Presenter.
        HomeScreenPresenter searchTrackOutputBoundary = new HomeScreenPresenter(viewManagerModel, homeScreenViewModel, loginViewModel);

        SearchTrackInputBoundary searchTrackInteractor = new SearchTrackInteractor(searchTrackOutputBoundary);

        return new SearchTrackController(searchTrackInteractor);
    }

    private static LogoutController createLogoutController(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            HomeScreenViewModel loggedInViewModel) {

        // Notice how we pass this method's parameters to the Presenter.
        LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(loginViewModel, loggedInViewModel, viewManagerModel);

        LogoutInputBoundary logoutInteractor = new LogoutInteractor(
                logoutOutputBoundary);

        return new LogoutController(logoutInteractor);
    }

    private static SearchArtistController createSearchArtistUseCase(
            ViewManagerModel viewManagerModel,
            HomeScreenViewModel homeScreenViewModel) {

        SearchArtistOutputBoundary searchArtistOutputBoundary =
                new SearchArtistPresenter(viewManagerModel, homeScreenViewModel);

        SearchArtistInputBoundary searchArtistInteractor = new SearchArtistInteractor(searchArtistOutputBoundary);

        return new SearchArtistController(searchArtistInteractor);
    }


}

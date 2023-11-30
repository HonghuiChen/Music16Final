package app;

import interface_adapter.GenrePreference.GenreController;
import interface_adapter.GenrePreference.GenrePresenter;
import interface_adapter.GenrePreference.GenreViewModel;
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
import use_case.addGenrePreference.addGenrePreferenceDataAccessInterface;
import use_case.addGenrePreference.addGenrePreferenceInputBoundary;
import use_case.addGenrePreference.addGenrePreferenceInteractor;
import use_case.addGenrePreference.addGenrePreferenceOutputBoundary;
import use_case.deleteGenrePreference.deleteGenrePreferenceDataAccessInterface;
import use_case.deleteGenrePreference.deleteGenrePreferenceInputBoundary;
import use_case.deleteGenrePreference.deleteGenrePreferenceInteractor;
import use_case.deleteGenrePreference.deleteGenrePreferenceOutputBoundary;
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
            HomeScreenViewModel homeScreenViewModel,
            GenreViewModel genreViewModel,
            addGenrePreferenceDataAccessInterface addGenreDataAccessObject,
            deleteGenrePreferenceDataAccessInterface deleteGenreDataAccessObject) {

        try {
            SearchTrackController searchTrackController = createSearchTrackController(viewManagerModel, loginViewModel, homeScreenViewModel);
            SearchArtistController searchArtistController = createSearchArtistUseCase(viewManagerModel, homeScreenViewModel);
            LogoutController logoutController = createLogoutController(viewManagerModel, loginViewModel, homeScreenViewModel);
            GenreController genreController = createGenreUseCase(viewManagerModel, genreViewModel, addGenreDataAccessObject, deleteGenreDataAccessObject);
            return new HomeScreenView(homeScreenViewModel, searchTrackController, searchArtistController, logoutController, genreController);
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "HS Factory Error: " + e.getMessage());
        }

        return null;
    }

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

    private static GenreController createGenreUseCase(
            ViewManagerModel viewManagerModel,
            GenreViewModel genreViewModel,
            addGenrePreferenceDataAccessInterface addGenreDataAccessObject,
            deleteGenrePreferenceDataAccessInterface deleteGenreDataAccessObject) {

        addGenrePreferenceOutputBoundary addGenreOutputBoundary =
                new GenrePresenter(viewManagerModel, genreViewModel);

        deleteGenrePreferenceOutputBoundary deleteGenreOutputBoundary =
                new GenrePresenter(viewManagerModel, genreViewModel);

        addGenrePreferenceInputBoundary addGenreInteractor = new addGenrePreferenceInteractor(addGenreDataAccessObject,
                addGenreOutputBoundary);

        deleteGenrePreferenceInputBoundary deleteGenreInteractor = new deleteGenrePreferenceInteractor(
                deleteGenreDataAccessObject,
                deleteGenreOutputBoundary);

        return new GenreController(addGenreInteractor, deleteGenreInteractor);
    }


}

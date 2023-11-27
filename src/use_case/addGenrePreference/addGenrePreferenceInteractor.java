package use_case.addGenrePreference;

import entity.User;
import interface_adapter.GenrePreference.GenreController;

import java.util.ArrayList;

public class addGenrePreferenceInteractor implements addGenrePreferenceInputBoundary {
    final addGenrePreferenceDataAccessInterface addGenrePreferenceDataAccessObject;
    final addGenrePreferenceOutputBoundary GenrePresenter;
    final GenreController genrePresenter;

    public addGenrePreferenceInteractor(addGenrePreferenceDataAccessInterface addgenrePreferenceDataAccessInterface,
                                        addGenrePreferenceOutputBoundary addgenrePreferenceOutputBoundary, GenreController genrePresenter) {
        this.addGenrePreferenceDataAccessObject = addgenrePreferenceDataAccessInterface;
        this.GenrePresenter = addgenrePreferenceOutputBoundary;
        this.genrePresenter = genrePresenter;
    }
    public void switchView() {
        genrePresenter.homeButton();
    }

    @Override
    public void execute(addGenrePreferenceInputData addgenrePreferenceInputData) {
        String username = addGenrePreferenceDataAccessObject.readCurrUser("currentUser.txt");
        ArrayList<String> availableGenres = getGenre.getAvailableGenres();
        if ( ! availableGenres.contains(addgenrePreferenceInputData.getGenre())) {
            GenrePresenter.prepareAddFailView("This is not a valid genre.");
        }
        if (addGenrePreferenceDataAccessObject.haveGenre(username, addgenrePreferenceInputData.getGenre())) {
            GenrePresenter.prepareAddFailView("Genre already inputted.");
        } else {
            String genre = addgenrePreferenceInputData.getGenre();
            User user = addGenrePreferenceDataAccessObject.get(genre);
            addGenrePreferenceOutputData addgenrePreferenceOutputData = new addGenrePreferenceOutputData(user.getUsername(), false);
            GenrePresenter.prepareAddSuccessView(addgenrePreferenceOutputData);
        }
    }
}
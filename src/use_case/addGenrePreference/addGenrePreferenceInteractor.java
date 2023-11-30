package use_case.addGenrePreference;

import app.api.Token;
import entity.User;
import interface_adapter.GenrePreference.GenreController;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class addGenrePreferenceInteractor implements addGenrePreferenceInputBoundary {
    final addGenrePreferenceDataAccessInterface addGenrePreferenceDataAccessObject;
    final addGenrePreferenceOutputBoundary GenrePresenter;

    public addGenrePreferenceInteractor(addGenrePreferenceDataAccessInterface addgenrePreferenceDataAccessInterface,
                                        addGenrePreferenceOutputBoundary addgenrePreferenceOutputBoundary) {
        this.addGenrePreferenceDataAccessObject = addgenrePreferenceDataAccessInterface;
        this.GenrePresenter = addgenrePreferenceOutputBoundary;
    }

    @Override
    public void execute(addGenrePreferenceInputData addgenrePreferenceInputData) throws FileNotFoundException {
        String username = addGenrePreferenceDataAccessObject.readCurrUser("currentUser.txt");
        getGenre.main(null);
        ArrayList<String> availableGenres = getGenre.getAvailableGenres();
        if ( ! availableGenres.contains(addgenrePreferenceInputData.getGenre())) {
            GenrePresenter.prepareAddFailView("This is not a valid genre.");
        }
        if (addGenrePreferenceDataAccessObject.haveGenre(username, addgenrePreferenceInputData.getGenre())) {
            GenrePresenter.prepareAddFailView("Genre already inputted.");
        } else {
            String genre = addgenrePreferenceInputData.getGenre();
            User user = addGenrePreferenceDataAccessObject.get(username);
            user.setGenrePreference(genre);
            addGenrePreferenceOutputData addGenrePreferenceOutputData = new addGenrePreferenceOutputData(genre, false);
            GenrePresenter.prepareAddSuccessView(addGenrePreferenceOutputData);
        }
    }

    @Override
    public void switchView() {
        addGenrePresenter.switchView();
    }
}
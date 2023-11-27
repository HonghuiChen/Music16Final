package use_case.addGenrePreference;

import entity.User;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class addGenrePreferenceInteractor implements addGenrePreferenceInputBoundary {
    final addGenrePreferenceDataAccessInterface addGenrePreferenceDataAccessObject;
    final addGenrePreferenceOutputBoundary addGenrePresenter;

    public addGenrePreferenceInteractor(addGenrePreferenceDataAccessInterface addgenrePreferenceDataAccessInterface,
                                        addGenrePreferenceOutputBoundary addgenrePreferenceOutputBoundary) {
        this.addGenrePreferenceDataAccessObject = addgenrePreferenceDataAccessInterface;
        this.addGenrePresenter = addgenrePreferenceOutputBoundary;
    }

    @Override
    public void execute(addGenrePreferenceInputData addgenrePreferenceInputData) throws FileNotFoundException {
        String username = addGenrePreferenceDataAccessObject.readCurrUser("currentUser.txt");
        ArrayList<String> availableGenres = getGenre.getAvailableGenres();
        if ( ! availableGenres.contains(addgenrePreferenceInputData.getGenre())) {
            addGenrePresenter.prepareAddFailView("This is not a valid genre.");
        }
        if (addGenrePreferenceDataAccessObject.haveGenre(username, addgenrePreferenceInputData.getGenre())) {
            addGenrePresenter.prepareAddFailView("Genre already inputted.");
        } else {
            String genre = addgenrePreferenceInputData.getGenre();
            User user = addGenrePreferenceDataAccessObject.get(genre);
            addGenrePreferenceOutputData addgenrePreferenceOutputData = new addGenrePreferenceOutputData(user.getUsername(), false);
            addGenrePresenter.prepareAddSuccessView(addgenrePreferenceOutputData);
        }
    }

    @Override
    public void switchView() {
        addGenrePresenter.switchView();
    }
}
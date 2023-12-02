package use_case.deleteGenrePreference;

import entity.User;
import use_case.addGenrePreference.getGenre;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class deleteGenrePreferenceInteractor implements deleteGenrePreferenceInputBoundary {
    final deleteGenrePreferenceDataAccessInterface deleteGenrePreferenceDataAccessObject;
    final deleteGenrePreferenceOutputBoundary deleteGenrePresenter;

    public deleteGenrePreferenceInteractor(deleteGenrePreferenceDataAccessInterface deletegenrePreferenceDataAccessInterface,
                                        deleteGenrePreferenceOutputBoundary deletegenrePreferenceOutputBoundary) {
        this.deleteGenrePreferenceDataAccessObject = deletegenrePreferenceDataAccessInterface;
        this.deleteGenrePresenter = deletegenrePreferenceOutputBoundary;
    }

    @Override
    public void execute(deleteGenrePreferenceInputData deletegenrePreferenceInputData) throws FileNotFoundException {
        String username = deleteGenrePreferenceDataAccessObject.readCurrUser("currentUser.txt");
        getGenre.initAvailableGenres();
        ArrayList<String> availableGenres = getGenre.getAvailableGenres();
        if ( ! availableGenres.contains(deletegenrePreferenceInputData.getGenre())) {
            deleteGenrePresenter.prepareDeleteFailView("This is not a valid genre.");
        } else if (!deleteGenrePreferenceDataAccessObject.haveGenre(username, deletegenrePreferenceInputData.getGenre())) {
            deleteGenrePresenter.prepareDeleteFailView("Genre is not in your preferences.");
        } else {
            String genre = deletegenrePreferenceInputData.getGenre();
            User user = deleteGenrePreferenceDataAccessObject.get(username);
            user.deleteGenrePreference(genre);
            deleteGenrePreferenceOutputData deletegenrePreferenceOutputData = new deleteGenrePreferenceOutputData(genre, false);
            deleteGenrePresenter.prepareDeleteSuccessView(deletegenrePreferenceOutputData);
        }
    }
}

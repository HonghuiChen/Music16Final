package use_case.deleteGenrePreference;

import entity.User;

import java.io.FileNotFoundException;

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
        if (!deleteGenrePreferenceDataAccessObject.haveGenre(username, deletegenrePreferenceInputData.getGenre())) {
            deleteGenrePresenter.prepareDeleteFailView("Genre is not in your preferences.");
        } else {
            String genre = deletegenrePreferenceInputData.getGenre();
            User user = deleteGenrePreferenceDataAccessObject.get(username);
            user.setGenrePreference(genre);
            deleteGenrePreferenceOutputData deletegenrePreferenceOutputData = new deleteGenrePreferenceOutputData(genre, false);
            deleteGenrePresenter.prepareDeleteSuccessView(deletegenrePreferenceOutputData);
        }
    }
}

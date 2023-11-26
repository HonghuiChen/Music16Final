package use_case.deleteGenrePreference;

import entity.User;

public class deleteGenrePreferenceInteractor {
    final deleteGenrePreferenceDataAccessInterface deleteGenrePreferenceDataAccessObject;
    final deleteGenrePreferenceOutputBoundary deleteGenrePresenter;

    public deleteGenrePreferenceInteractor(deleteGenrePreferenceDataAccessInterface deletegenrePreferenceDataAccessInterface,
                                        deleteGenrePreferenceOutputBoundary deletegenrePreferenceOutputBoundary) {
        this.deleteGenrePreferenceDataAccessObject = deletegenrePreferenceDataAccessInterface;
        this.deleteGenrePresenter = deletegenrePreferenceOutputBoundary;
    }

    @Override
    public void execute(deleteGenrePreferenceInputData deletegenrePreferenceInputData) {
        String username = deleteGenrePreferenceDataAccessObject.readCurrUser("currentUser.txt");
        if (!deleteGenrePreferenceDataAccessObject.haveGenre(username, deletegenrePreferenceInputData.getGenre())) {
            deleteGenrePresenter.prepareDeleteFailView("Genre is not in your preferences.");
        } else {
            String genre = deletegenrePreferenceInputData.getGenre();
            User user = deleteGenrePreferenceDataAccessObject.get(genre);
            deleteGenrePreferenceOutputData deletegenrePreferenceOutputData = new deleteGenrePreferenceOutputData(user.getUsername(), false);
            deleteGenrePresenter.prepareDeleteSuccessView(deletegenrePreferenceOutputData);
        }
    }
}

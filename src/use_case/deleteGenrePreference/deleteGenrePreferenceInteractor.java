package use_case.deleteGenrePreference;

import entity.User;

public class addGenrePreferenceInteractor implements deleteGenrePreferenceInputBoundary{
    final deleteGenrePreferenceDataAccessInterface deleteGenrePreferenceDataAccessObject;
    final deleteGenrePreferenceOutputBoundary deleteGenrePresenter;
    final User user;
    public addGenrePreferenceInteractor(deleteGenrePreferenceDataAccessInterface deletegenrePreferenceDataAccessInterface,
                                        deleteGenrePreferenceOutputBoundary deletegenrePreferenceOutputBoundary) {
        this.deleteGenrePreferenceDataAccessObject = deletegenrePreferenceDataAccessInterface;
        this.deleteGenrePresenter = deletegenrePreferenceOutputBoundary;
        this.user =
    }
    @Override
    public void execute(deleteGenrePreferenceInputData deletegenrePreferenceInputData) {
        if (deleteGenrePreferenceDataAccessObject.haveGenre(loggedIn,
                deletegenrePreferenceInputData.getGenre())) {
            userPresenter.prepareFailView("Genre is either already deleted or not in your preference.");
        } else {
            //String genre = ...
            //userDataAccessObject.addGenre(genre);
            deleteGenrePreferenceOutputData deletegenrePreferenceOutputData = new deleteGenrePreferenceOutputData();
            userPresenter.prepareSuccessView(deletegenrePreferenceOutputData);

        }
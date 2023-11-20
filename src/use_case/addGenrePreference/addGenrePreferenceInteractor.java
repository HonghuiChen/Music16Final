package use_case.addGenrePreference;

import entity.User;

public class addGenrePreferenceInteractor implements addGenrePreferenceInputBoundary{
    final addGenrePreferenceDataAccessInterface addGenrePreferenceDataAccessObject;
    final addGenrePreferenceOutputBoundary addGenrePresenter;
    final User user;
    public addGenrePreferenceInteractor(addGenrePreferenceDataAccessInterface addgenrePreferenceDataAccessInterface,
                                        addGenrePreferenceOutputBoundary addgenrePreferenceOutputBoundary) {
        this.addGenrePreferenceDataAccessObject = addgenrePreferenceDataAccessInterface;
        this.addGenrePresenter = addgenrePreferenceOutputBoundary;
        this.user =
        }
    @Override
    public void execute(addGenrePreferenceInputData addgenrePreferenceInputData) {
        if (addGenrePreferenceDataAccessObject.haveGenre( ,
                addgenrePreferenceInputData.getGenre())) {
            userPresenter.prepareFailView("Genre already inputted.");
        } else {
            //String genre = ...
            //userDataAccessObject.addGenre(genre);
            addGenrePreferenceOutputData addgenrePreferenceOutputData = new addGenrePreferenceOutputData();
            userPresenter.prepareSuccessView(addgenrePreferenceOutputData);

    }
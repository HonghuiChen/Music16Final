package app;

import interface_adapter.GenrePreference.GenreController;
import interface_adapter.GenrePreference.GenrePresenter;
import interface_adapter.GenrePreference.GenreViewModel;
import interface_adapter.ViewManagerModel;
import use_case.addGenrePreference.addGenrePreferenceDataAccessInterface;
import use_case.addGenrePreference.addGenrePreferenceInputBoundary;
import use_case.addGenrePreference.addGenrePreferenceInteractor;
import use_case.addGenrePreference.addGenrePreferenceOutputBoundary;
import use_case.deleteGenrePreference.deleteGenrePreferenceDataAccessInterface;
import use_case.deleteGenrePreference.deleteGenrePreferenceInputBoundary;
import use_case.deleteGenrePreference.deleteGenrePreferenceInteractor;
import use_case.deleteGenrePreference.deleteGenrePreferenceOutputBoundary;
import view.GenreView;

import javax.swing.*;
import java.io.IOException;

public class GenreUseCaseFactory {

    private GenreUseCaseFactory() {}

    public static GenreView create(
            ViewManagerModel viewManagerModel,
            GenreViewModel genreViewModel,
            addGenrePreferenceDataAccessInterface userDataAccessInterface
    ) {
        GenreController genreController = createGenreUseCase(viewManagerModel, genreViewModel, userDataAccessInterface);
        return new GenreView(genreViewModel, genreController);
    }

    public static GenreController createGenreUseCase(
            ViewManagerModel viewManagerModel,
            GenreViewModel genreViewModel,
            addGenrePreferenceDataAccessInterface userDataAccessInterface
    ) {
        addGenrePreferenceOutputBoundary genrePresenter = new GenrePresenter(viewManagerModel, genreViewModel);
        addGenrePreferenceInputBoundary addGenreInteractor = new addGenrePreferenceInteractor(userDataAccessInterface, genrePresenter);
        deleteGenrePreferenceInputBoundary deleteGenreInteractor = new deleteGenrePreferenceInteractor
                ((deleteGenrePreferenceDataAccessInterface) userDataAccessInterface, (deleteGenrePreferenceOutputBoundary) genrePresenter);
        return new GenreController(addGenreInteractor, deleteGenreInteractor);
    }
}

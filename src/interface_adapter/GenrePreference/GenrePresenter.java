package interface_adapter.GenrePreference;

import interface_adapter.ViewManagerModel;
import interface_adapter.GenrePreference.GenreViewModel;
import use_case.addGenrePreference.addGenrePreferenceOutputBoundary;
import use_case.addGenrePreference.addGenrePreferenceOutputData;
import use_case.deleteGenrePreference.deleteGenrePreferenceOutputBoundary;
import use_case.deleteGenrePreference.deleteGenrePreferenceOutputData;

public class GenrePresenter
        implements addGenrePreferenceOutputBoundary, deleteGenrePreferenceOutputBoundary {
    private GenreViewModel genreViewModel;
    private ViewManagerModel viewManagerModel;


    public GenrePresenter(ViewManagerModel viewManagerModel, GenreViewModel genreViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.genreViewModel = genreViewModel;
    }

    @Override
    public void prepareAddSuccessView(addGenrePreferenceOutputData response){
        GenreState GenreState = genreViewModel.getState();
        GenreState.setGenre(response.getGenre());
        this.viewManagerModel.setActiveView(genreViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareAddFailView(String error) {
        GenreState GenreState = genreViewModel.getState();
        GenreState.setGenreError(error);
        genreViewModel.firePropertyChanged();
    }

    @Override
    public void prepareDeleteSuccessView(deleteGenrePreferenceOutputData response){
        GenreState GenreState = genreViewModel.getState();
        GenreState.setGenre(response.getGenre());
        this.viewManagerModel.setActiveView(genreViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareDeleteFailView(String error) {
        GenreState GenreState = genreViewModel.getState();
        GenreState.setGenreError(error);
        genreViewModel.firePropertyChanged();
    }
    @Override
    public void cancel() {
        genreViewModel = new GenreViewModel();
        this.viewManagerModel.setActiveView(genreViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

}


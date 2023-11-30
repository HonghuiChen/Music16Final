package interface_adapter.GenrePreference;

import use_case.addGenrePreference.addGenrePreferenceInputBoundary;
import use_case.deleteGenrePreference.deleteGenrePreferenceInputBoundary;
import use_case.addGenrePreference.addGenrePreferenceInputData;
import use_case.deleteGenrePreference.deleteGenrePreferenceInputData;

import java.io.FileNotFoundException;

public class GenreController {
    final addGenrePreferenceInputBoundary addGenrePreferenceInteractor;
    final deleteGenrePreferenceInputBoundary deleteGenrePreferenceInteractor;

    public GenreController(addGenrePreferenceInputBoundary addGenrePreferenceInteractor,
                           deleteGenrePreferenceInputBoundary deleteGenrePreferenceInteractor) {
        this.addGenrePreferenceInteractor = addGenrePreferenceInteractor;
        this.deleteGenrePreferenceInteractor = deleteGenrePreferenceInteractor;
    }

    public void add(String genre) throws FileNotFoundException {
        addGenrePreferenceInputData addGenrePreferenceInputData =
                new addGenrePreferenceInputData(genre);
        addGenrePreferenceInteractor.execute(addGenrePreferenceInputData);
    }

    public void delete(String genre) throws FileNotFoundException {
        deleteGenrePreferenceInputData deleteGenrePreferenceInputData =
                new deleteGenrePreferenceInputData(genre);
        deleteGenrePreferenceInteractor.execute(deleteGenrePreferenceInputData);
    }

    public void switchView() {addGenrePreferenceInteractor.switchView();}

}

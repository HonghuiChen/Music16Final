package interface_adapter.GenrePreference;

import use_case.addGenrePreference.addGenrePreferenceInputBoundary;
import use_case.deleteGenrePreference.deleteGenrePreferenceInputBoundary;
import use_case.addGenrePreference.addGenrePreferenceInputData;
import use_case.deleteGenrePreference.deleteGenrePreferenceInputData;

public class GenreController {
    final addGenrePreferenceInputBoundary addGenrePreferenceInteractor;
    final deleteGenrePreferenceInputBoundary deleteGenrePreferenceInteractor;

    public GenreController(addGenrePreferenceInputBoundary addGenrePreferenceInteractor,
                           deleteGenrePreferenceInputBoundary deleteGenrePreferenceInteractor) {
        this.addGenrePreferenceInteractor = addGenrePreferenceInteractor;
        this.deleteGenrePreferenceInteractor = deleteGenrePreferenceInteractor;
    }

    public void add(String genre) {
        addGenrePreferenceInputData addGenrePreferenceInputData =
                new addGenrePreferenceInputData(genre);
        addGenrePreferenceInteractor.execute(addGenrePreferenceInputData);
    }

    public void delete(String genre) {
        deleteGenrePreferenceInputData deleteGenrePreferenceInputData =
                new deleteGenrePreferenceInputData(genre);
        deleteGenrePreferenceInteractor.execute(deleteGenrePreferenceInputData);
    }

    public void homeButton() {
        addGenrePreferenceInteractor.switchView();
        deleteGenrePreferenceInteractor.switchView();
    }

}

package use_case.deleteGenrePreference;

import use_case.deleteGenrePreference.deleteGenrePreferenceOutputData;

public interface deleteGenrePreferenceOutputBoundary {
    void prepareDeleteSuccessView(deleteGenrePreferenceOutputData user);
    void prepareDeleteFailView(String error);
    void cancel();

}

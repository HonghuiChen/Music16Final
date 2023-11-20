package use_case.deleteGenrePreference;

import use_case.deleteGenrePreference.deleteGenrePreferenceOutputData;

public class deleteGenrePreferenceOutputBoundary {
    void prepareSuccessView(deleteGenrePreferenceOutputData user);
    void prepareFailView(String error);
}

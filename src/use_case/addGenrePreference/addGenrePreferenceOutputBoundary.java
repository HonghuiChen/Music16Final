package use_case.addGenrePreference;

public interface addGenrePreferenceOutputBoundary {
    void prepareSuccessView(addGenrePreferenceOutputData user);
    void prepareFailView(String error);
}

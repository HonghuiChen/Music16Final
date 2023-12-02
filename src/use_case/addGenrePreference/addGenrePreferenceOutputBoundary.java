package use_case.addGenrePreference;

public interface addGenrePreferenceOutputBoundary {
    void prepareAddSuccessView(addGenrePreferenceOutputData user);
    void prepareAddFailView(String error);
    void switchView();

    void cancel();
}

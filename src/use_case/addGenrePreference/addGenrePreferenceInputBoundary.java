package use_case.addGenrePreference;

import java.io.FileNotFoundException;

public interface addGenrePreferenceInputBoundary {
    void execute(addGenrePreferenceInputData addgenrePreferenceInputData) throws FileNotFoundException;

    void switchView();
}

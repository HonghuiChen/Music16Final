package use_case.deleteGenrePreference;

import java.io.FileNotFoundException;

public interface deleteGenrePreferenceInputBoundary {
    void execute(deleteGenrePreferenceInputData deletegenrePreferenceInputData) throws FileNotFoundException;
}


import org.junit.jupiter.api.Test;
import use_case.addGenrePreference.addGenrePreferenceInputData;
import use_case.deleteGenrePreference.deleteGenrePreferenceInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class deleteGenrePreferenceInputDataTest {
    deleteGenrePreferenceInputData deleteGenreInputData = new deleteGenrePreferenceInputData("genre");
    @Test
    void getGenreTest() {
        assertEquals("genre", deleteGenreInputData.getGenre());
    }
}

import org.junit.jupiter.api.Test;
import use_case.addGenrePreference.addGenrePreferenceInputData;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddGenrePreferenceInputDataTest {
    addGenrePreferenceInputData addGenreInputData = new addGenrePreferenceInputData("genre");
    @Test
    void getGenreTest() {
        assertEquals("genre", addGenreInputData.getGenre());
    }
}

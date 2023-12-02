import org.junit.jupiter.api.Test;
import use_case.addGenrePreference.addGenrePreferenceOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class AddGenrePreferenceOutputDataTest {
    addGenrePreferenceOutputData addgenrePreferenceOutputData = new addGenrePreferenceOutputData("pop", false);
    @Test
    void getGenre() {
        assertEquals("pop", addgenrePreferenceOutputData.getGenre());
    }

    @Test
    void isUseCaseFailed() {
        assertFalse(addgenrePreferenceOutputData.isUseCaseFailed());
    }
}

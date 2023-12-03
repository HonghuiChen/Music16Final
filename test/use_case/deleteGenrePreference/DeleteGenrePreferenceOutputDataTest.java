import org.junit.jupiter.api.Test;
import use_case.deleteGenrePreference.deleteGenrePreferenceOutputData;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class DeleteGenrePreferenceOutputDataTest {
    deleteGenrePreferenceOutputData deletegenrePreferenceOutputData = new deleteGenrePreferenceOutputData("pop", false);
    @Test
    void getGenre() {
        assertEquals("pop", deletegenrePreferenceOutputData.getGenre());
    }

    @Test
    void isUseCaseFailed() {
        assertFalse(deletegenrePreferenceOutputData.isUseCaseFailed());
    }
}

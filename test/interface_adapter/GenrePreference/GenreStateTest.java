package interface_adapter.GenrePreference;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GenreStateTest {
    @Test
    void testDefaultConstructor() {
        GenreState state = new GenreState();
        assertNull(state.getAddGenreError());
        assertNull(state.getDeleteGenreError());
    }

    @Test
    void testCopyConstructor() {
        GenreState original = new GenreState();
        original.setGenre("genre");
        original.setAddGenreError("add genre error");
        original.setDeleteGenreError("delete genre error");

        GenreState copy = new GenreState(original);
        assertEquals("genre", copy.getGenre());
        assertEquals("add genre error", copy.getAddGenreError());
        assertEquals("delete genre error", copy.getDeleteGenreError());
    }

    @Test
    void testSettersAndGetters() {
        GenreState state = new GenreState();
        state.setGenre("genre");
        state.setDeleteGenreError("delete genre error");
        state.setAddGenreError("add genre error");

        assertEquals("genre", state.getGenre());
        assertEquals("add genre error", state.getAddGenreError());
        assertEquals("delete genre error", state.getDeleteGenreError());
        System.out.println(state);
    }
}

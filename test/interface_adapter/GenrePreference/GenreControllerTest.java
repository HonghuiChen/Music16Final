package interface_adapter.GenrePreference;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.addGenrePreference.addGenrePreferenceInputBoundary;
import use_case.addGenrePreference.addGenrePreferenceInputData;
import use_case.deleteGenrePreference.*;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GenreControllerTest {
    @Mock
    private addGenrePreferenceInputBoundary addGenreInteractor;
    @Mock
    private deleteGenrePreferenceInputBoundary deleteGenreInteractor;

    private GenreController genreController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        genreController = new GenreController(addGenreInteractor, deleteGenreInteractor);
    }

    @Test
    void testAdd() throws IOException {
        genreController.add("pop");
        verify(addGenreInteractor, times(1)).execute(any(addGenrePreferenceInputData.class));
    }

    @Test
    void testDelete() throws IOException {
        genreController.delete("pop");
        verify(deleteGenreInteractor, times(1)).execute(any(deleteGenrePreferenceInputData.class));
    }

    @Test
    void testSwitchView() {
        genreController.switchView();
        verify(addGenreInteractor, times(1)).switchView();
    }

    @Test
    void testCancel() {
        genreController.cancel();
        verify(addGenreInteractor, times(1)).cancel();
    }
}

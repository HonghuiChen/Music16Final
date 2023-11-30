package interface_adapter.SearchTrack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.SearchTrack.SearchTrackInputBoundary;
import use_case.SearchTrack.SearchTrackInputData;

import java.io.IOException;

import static org.mockito.Mockito.*;


class SearchTrackControllerTest {

    @Mock
    private SearchTrackInputBoundary searchTrackInteractor;
    private SearchTrackController searchTrackController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        searchTrackController = new SearchTrackController(searchTrackInteractor);
    }

    @Test
    void testExecute() throws IOException {
        searchTrackController.execute("Lady by the sea");
        verify(searchTrackInteractor, times(1)).search(any(SearchTrackInputData.class));
    }
}
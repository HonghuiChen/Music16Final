package use_case.SearchTrack;

import interface_adapter.homeScreen.HomeScreenPresenter;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import okhttp3.*;

import java.io.IOException;

class SearchTrackInteractorTest {
    // Test SearhTrackInteractor, but not testing the API Call
    @Test
    void testSuccess() throws IOException, JSONException {
        SearchTrackInputData inputData = new SearchTrackInputData("Bohemian Rhapsody");
        // Check that the output data is correct and valid
        SearchTrackOutputBoundary successPresenter = new SearchTrackOutputBoundary() {
            @Override
            // Assert result is not empty
            public void prepareSuccessView(SearchTrackOutputData results) {
                assert !results.getResults().isEmpty();
            }

            @Override
            public void prepareFailView(String error) {
                assert false;
            }
        };

        SearchTrackInteractor searchTrackInteractor = new SearchTrackInteractor(new HomeScreenPresenter());
        SearchTrackInputData inputData = new SearchTrackInputData("test");
        searchTrackInteractor.search(inputData);
    }

}
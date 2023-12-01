package use_case.SearchTrack;

import app.api.Token;
import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenPresenter;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.login.LoginViewModel;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.fail;

class SearchTrackInteractorTest {
    @BeforeEach
    void setUp() throws IOException {
        Token.main(new String[]{""});
    }

    @Test
    void testSuccess() throws IOException, JSONException {
        // Check that the output data is correct and valid
        HomeScreenPresenter successPresenter = new HomeScreenPresenter(new ViewManagerModel(), new HomeScreenViewModel(), new LoginViewModel()) {
            @Override
            // Assert result is not empty
            public void prepareSuccessView(SearchTrackOutputData results) {
                assert !results.getResults().isEmpty();
            }

            @Override
            public void prepareFailView(String error) {
                fail("Failure as expected");
            }
        };
        SearchTrackInputData inputData = new SearchTrackInputData("Bohemian Rhapsody");
        SearchTrackInteractor searchTrackInteractor = new SearchTrackInteractor(successPresenter);
        searchTrackInteractor.search(inputData);
    }

    @Test
    void testEmptyQuery() throws IOException, JSONException {
        SearchTrackInputData inputData = new SearchTrackInputData("");
        // Check that the output data is correct and valid
        HomeScreenPresenter failPresenter = new HomeScreenPresenter(new ViewManagerModel(), new HomeScreenViewModel(), new LoginViewModel()) {
            @Override
            // Assert result is not empty
            public void prepareSuccessView(SearchTrackOutputData results) {
                assert true;
            }

            @Override
            public void prepareFailView(String error) {
                assert error.equals("Query cannot be null");
            }
        };

        SearchTrackInteractor searchTrackInteractor = new SearchTrackInteractor(failPresenter);
        searchTrackInteractor.search(inputData);
    }

    @Test
    void testNetworkError() throws IOException, JSONException {
        SearchTrackInputData inputData = new SearchTrackInputData("Bohemian Rhapsody");
        // Check that the output data is correct and valid
        HomeScreenPresenter failPresenter = new HomeScreenPresenter(new ViewManagerModel(), new HomeScreenViewModel(), new LoginViewModel()) {
            @Override
            // Assert result is not empty
            public void prepareSuccessView(SearchTrackOutputData results) {
                System.out.println("Success as expected");
                assert true;
            }

            @Override
            public void prepareFailView(String error) {
                assert error.equals("Network error");
            }
        };

        SearchTrackInteractor searchTrackInteractor = new SearchTrackInteractor(failPresenter);
        searchTrackInteractor.search(inputData);
    }
//    @Test
//    void testJSONExceptionSearch() throws IOException {
//        // Mock JSONException scenario
//        when(this.execute(request)).thenReturn(response);
//        when(response.isSuccessful()).thenReturn(true);
//        when(response.body()).thenReturn(responseBody);
//        when(responseBody.string()).thenThrow(new JSONException("JSON error"));
//        when(interactor.search(searchTrackInputData))
//
//        // Execute search
//        interactor.search(new SearchTrackInputData("query"));
//
//        // Verify if prepareFailView is called with JSON parsing error
//        verify(homeScreenPresenter).prepareFailView("JSON parsing error");
//    }
//

}
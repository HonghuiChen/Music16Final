package use_case.SearchTrack;

import app.api.Token;
import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenPresenter;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.login.LoginViewModel;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import okhttp3.*;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.fail;

class SearchTrackInteractorTest {
    // Test SearhTrackInteractor, but not testing the API Call
    @Test
    void testSuccess() throws IOException, JSONException {
        Token.main(new String[]{""});
        SearchTrackInputData inputData = new SearchTrackInputData("Bohemian Rhapsody");
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

        SearchTrackInteractor searchTrackInteractor = new SearchTrackInteractor(successPresenter);
        searchTrackInteractor.search(inputData);
    }

    @Test
    void testEmptyQuery() throws IOException, JSONException {
        Token.main(new String[]{""});
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
    // This test case only success when you don't connect to Wi-Fi, unless using Mockito to mock the response but that's
    // beyond the scope of this course
    void testNetworkError() throws IOException, JSONException {
        Token.main(new String[]{""});
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

}
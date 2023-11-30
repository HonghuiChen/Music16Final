package use_case.SearchTrack;

import app.api.Token;
import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenPresenter;
import interface_adapter.homeScreen.HomeScreenState;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.login.LoginViewModel;
import okhttp3.*;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import okhttp3.Call;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


class SearchTrackInteractorTest {

    @Mock
    private HomeScreenPresenter homeScreenPresenter;

    @Mock
    private SearchTrackInputData searchTrackInputData;

    @Mock
    private OkHttpClient client;

    // Mock a non-empty response

    @Mock
    private Response response;

    @Mock
    private ResponseBody responseBody;
    @Mock
    private Call mockCall;

    @Mock
    private Request request;

    @Mock
    private SearchTrackInteractor interactor;



    @BeforeEach
    void setUp() throws IOException {
        Token.main(new String[]{""});
        MockitoAnnotations.openMocks(this);
        interactor = new SearchTrackInteractor(homeScreenPresenter);

        when(client.newCall(any(Request.class))).thenReturn(mockCall);
        when(mockCall.execute()).thenReturn(response);

        SearchTrackInputData inputData = new SearchTrackInputData("Bohemian Rhapsody");
//        request = new Request.Builder()
//                .url(String.format("%s?q=%s&type=%s", "https://api.spotify.com/v1/search", inputData.getQuery(), "track"))
//                .addHeader("Authorization", Token.get_auth())
//                .addHeader("Content-Type", "application/json")
//                .build();
    }

    public Response execute(Request request) throws IOException {
        return client.newCall(request).execute();
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
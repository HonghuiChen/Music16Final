package interface_adapter.SearchArtist;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import use_case.SearchArtist.SearchArtistInputData;
import use_case.SearchArtist.SearchArtistInteractor;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class SearchArtistControllerTest {

    @Test
    void executeTest() throws IOException {
        String query = "Taylor";
        SearchArtistInteractor interactor = new SearchArtistInteractor() {
            @Override
            public void execute(SearchArtistInputData searchArtistInputData) throws IOException, JSONException {
                assertEquals(searchArtistInputData.getQuery(), query);
            }
        };

        SearchArtistController controller = new SearchArtistController(interactor);
        controller.execute(query);
    }

}
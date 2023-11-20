package use_case.SearchArtist;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class SearchArtistInteractorTest {

    @Test
    void successTest() throws IOException {
        SearchArtistInputData inputData = new SearchArtistInputData("Eminem");

        SearchArtistOutputBoundary successPresenter = new SearchArtistOutputBoundary() {
            @Override
            public void prepareSuccessView(SearchArtistOutputData artistInfo) {
                assertEquals("Eminem", artistInfo.getArtistName());

                ArrayList<String > genres = new ArrayList<>();
                genres.add("detroit hip hop");
                genres.add("hip hop");
                genres.add("rap");
                assertEquals(genres, artistInfo.getGenres());

                assertEquals("78528512", artistInfo.getFollowers());
            }

            @Override
            public void prepareFailView(String error) {
                fail("Use case failure is unexpected.");
            }
        };

        SearchArtistInteractor interactor = new SearchArtistInteractor(successPresenter);
        interactor.execute(inputData);

    }

}
package use_case.addGenrePreference;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import use_case.SearchArtist.SearchArtistInputData;
import use_case.SearchArtist.SearchArtistInteractor;
import use_case.SearchArtist.SearchArtistOutputBoundary;
import use_case.SearchArtist.SearchArtistOutputData;
import use_case.SearchTrack.SearchTrackInputData;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class addGenrePreferenceInteractorTest {

    @Test
    void successTest() throws IOException {
        addGenrePreferenceInputData inputData = new addGenrePreferenceInputData("Pop");

        @Override
        public void prepareAddSuccessView()

        @Override
        public void prepareAddFailView(String error) {
            fail("Use case failure is unexpected.");
        }
    }

    @Test

        addGenrePreferenceInteractor interactor = new addGenrePreferenceInteractor(successPresenter);
        interactor.execute(inputData);
    }
}

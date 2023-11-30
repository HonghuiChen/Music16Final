package use_case.LikeArtist;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LikeArtistsInteractorTest{

    @Test
    void successTest() throws IOException{
        LikeArtistsInputData input = new LikeArtistsInputData("Tulus");

        LikeArtistsOutputBoundary successPresenter = new LikeArtistsOutputBoundary {
            @Override
            public void prepareLikeSuccessView(LikeArtistsOutputData artist){
                assertEquals("Tulus", artist.getArtists());
            }

            @Override
            public void prepareUnlikeSuccessView(LikeArtistsOutputData artist){
                assertEquals("Tulus", artist.getArtists());
            }

            @Override
            public void prepareFailView(String error){
                fail("Use case failure is unexpected.");
            }
        }
        LikeArtistsInteractor interactor = new LikeArtistsInteractor(successPresenter);
        interactor.like(input);
        interactor.unlike(input); // shoul we divide the test case for like and unlike?

    }
}
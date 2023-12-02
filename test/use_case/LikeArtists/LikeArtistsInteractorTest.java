package use_case.LikeArtists;

import entity.User;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LikeArtistsInteractorTest{

    @Test
    void successTest() throws IOException{
        LikeArtistsInputData input = new LikeArtistsInputData("Tulus");

        LikeArtistsDataAccessInterface data = new LikeArtistsDataAccessInterface() {
            @Override
            public boolean existsByArtists(String username, String song) {
                return false;
            }

            @Override
            public String readCurrUser(String fname) {
                return null;
            }

            @Override
            public User get(String username) {
                return null;
            }
        };
        LikeArtistsOutputBoundary successPresenter = new LikeArtistsOutputBoundary (){
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
        };
        LikeArtistsInteractor interactor = new LikeArtistsInteractor(data, successPresenter);
        interactor.like(input);
        interactor.unlike(input);

    }
}
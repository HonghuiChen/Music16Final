package use_case.LikeTracks;

import entity.User;
import org.junit.jupiter.api.Test;


import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LikeTracksInteractorTest{
    @Test
    void successTest() throws IOException {
        LikeTracksInputData input = new LikeTracksInputData("Interaksi");

        LikeTracksDataAccessInterface data = new LikeTracksDataAccessInterface() {
            @Override
            public boolean existsByTracks(String username, String song) {
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
        LikeTracksOutputBoundary successPresenter = new LikeTracksOutputBoundary(){
            @Override
            public void prepareLikeSuccessView(LikeTracksOutputData song){
                assertEquals("Interaksi", song.getSong());
            }

            @Override
            public void prepareUnlikeSuccessView(LikeTracksOutputData song){
                assertEquals("Interaksi", song.getSong());
            }

            @Override
            public void prepareFailView(String error){
                fail("Use case failure is unexpected.");
        }
    };
    LikeTracksInteractor interactor = new LikeTracksInteractor(data, successPresenter);
        interactor.like(input);
        interactor.unlike(input);
}}
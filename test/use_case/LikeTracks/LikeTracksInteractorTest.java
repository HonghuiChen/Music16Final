package use_case.LikeTracks;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LikeTracksInteractorTest{
    @Test
    void successTest() throws IOException{
        LikeTracksInputData input = new LikeTracksInputData("Interaksi");
        LikeTracksOutputBoundary successPresenter = new LikeTracksOutputBoundary {
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
    }
    LikeTracksInteractor interactor = new LikeTracksInteractor(successPresenter);
        interactor.like(input);
        interactor.unlike(input);
}
package use_case.LikeTracks;

import entity.User;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

class LikeTracksInteractorTest{
    @Test
    void successTest() throws FileNotFoundException {
        User userMock = mock(User.class);
        LikeTracksDataAccessInterface MockData = mock(LikeTracksDataAccessInterface.class);
        LikeTracksOutputBoundary MockOutput = mock(LikeTracksOutputBoundary.class);

        LikeTracksInteractor interactor = new LikeTracksInteractor(MockData, MockOutput);

        when(MockData.readCurrUser("currentUser.txt")).thenReturn("testUser");
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        when(MockData.get("testUser")).thenReturn(new User("testUser", "1234", mockDateTime));
        when(MockData.existsByTracks("testuser", "Lover")).thenReturn(false);
        ArrayList<String> songs = new ArrayList<>();
        songs.add("Lover");
        when(userMock.getFavoriteSongs()).thenReturn(songs);

        LikeTracksInputData input = new LikeTracksInputData("Lover");

        interactor.like(input);
        interactor.unlike(input);

        verify(MockOutput).prepareLikeSuccessView(any(LikeTracksOutputData.class));
        verify(MockOutput).prepareUnlikeSuccessView(any(LikeTracksOutputData.class));
        verify(MockOutput, times(0)).prepareFailView(anyString());

    }

    @Test
    void failTest() throws FileNotFoundException {
        User userMock = mock(User.class);
        LikeTracksDataAccessInterface MockData = mock(LikeTracksDataAccessInterface.class);
        LikeTracksOutputBoundary MockOutput = mock(LikeTracksOutputBoundary.class);

        LikeTracksInteractor interactor = new LikeTracksInteractor(MockData, MockOutput);

        when(MockData.readCurrUser("currentUser.txt")).thenReturn("testUser");
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        when(MockData.get("testUser")).thenReturn(new User("testUser", "1234", mockDateTime));
        when(MockData.existsByTracks("testUser", "Lover")).thenReturn(true);
        ArrayList<String> songs = new ArrayList<>();
        songs.add("Lover");
        when(userMock.getFavoriteSongs()).thenReturn(songs);

        LikeTracksInputData input = new LikeTracksInputData("Lover");

        interactor.like(input);

        verify(MockOutput).prepareFailView("You already liked this song");
        verify(MockOutput, times(0)).prepareLikeSuccessView(any(LikeTracksOutputData.class));

        // "You already liked this song"
    }
}

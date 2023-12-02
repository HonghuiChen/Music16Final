package use_case.LikeArtists;

import entity.User;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class LikeArtistsOutputDataTest {

    void successTest() throws FileNotFoundException {
        User userMock = mock(User.class);
        LikeArtistsDataAccessInterface MockData = mock(LikeArtistsDataAccessInterface.class);
        LikeArtistsOutputBoundary MockOutput = mock(LikeArtistsOutputBoundary.class);

        LikeArtistsInteractor interactor = new LikeArtistsInteractor(MockData, MockOutput);

        when(MockData.readCurrUser("currentUser.txt")).thenReturn("testUser");
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        when(MockData.get("testUser")).thenReturn(new User("testUser", "1234", mockDateTime));
        when(MockData.existsByArtists("testuser", "Ed Sheeran")).thenReturn(false);
        ArrayList<String> artists = new ArrayList<>();
        artists.add("Ed Sheeran");
        when(userMock.getFavoriteArtist()).thenReturn(artists);

        LikeArtistsInputData input = new LikeArtistsInputData("Ed Sheeran");

        interactor.like(input);
        interactor.unlike(input);

        verify(MockOutput).prepareLikeSuccessView(any(LikeArtistsOutputData.class));
        verify(MockOutput).prepareUnlikeSuccessView(any(LikeArtistsOutputData.class));
        verify(MockOutput, times(0)).prepareFailView(anyString());

    }
}

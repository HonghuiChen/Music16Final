import entity.User;
import org.junit.jupiter.api.Test;
import use_case.addGenrePreference.*;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class AddGenrePreferenceInteractorTest {

    @Test
    void successTest() throws FileNotFoundException {
        User userMock = mock(User.class);
        addGenrePreferenceDataAccessInterface dataAccessMock = mock(addGenrePreferenceDataAccessInterface.class);
        addGenrePreferenceOutputBoundary outputBoundaryMock = mock(addGenrePreferenceOutputBoundary.class);

        // Create the interactor
        addGenrePreferenceInteractor interactor =
                new addGenrePreferenceInteractor(dataAccessMock, outputBoundaryMock);

        // Mock data and behavior
        when(dataAccessMock.readCurrUser("currentUser.txt")).thenReturn("testUser");
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        when(dataAccessMock.get("testUser")).thenReturn(new User("testUser", "1234", mockDateTime));
        when(dataAccessMock.haveGenre("testUser", "pop")).thenReturn(false);
        ArrayList<String> genres = new ArrayList<>();
        genres.add("pop");
        genres.add("rock");
        when(userMock.getGenrePreference()).thenReturn(genres);

        // Create input data
        addGenrePreferenceInputData inputData = new addGenrePreferenceInputData("pop");

        // Execute the method
        interactor.execute(inputData);

        // Verify interactions and assertions
        verify(outputBoundaryMock).prepareAddSuccessView(any(addGenrePreferenceOutputData.class));
        verify(outputBoundaryMock, times(0)).prepareAddFailView(anyString());
        verify(outputBoundaryMock, times(0)).switchView();
    }

    @Test
    void failTest() throws FileNotFoundException {
        User userMock = mock(User.class);
        addGenrePreferenceDataAccessInterface dataAccessMock = mock(addGenrePreferenceDataAccessInterface.class);
        addGenrePreferenceOutputBoundary outputBoundaryMock = mock(addGenrePreferenceOutputBoundary.class);

        // Create the interactor
        addGenrePreferenceInteractor interactor =
                new addGenrePreferenceInteractor(dataAccessMock, outputBoundaryMock);

        // Mock data and behavior
        when(dataAccessMock.readCurrUser("currentUser.txt")).thenReturn("testUser");
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        when(dataAccessMock.get("testUser")).thenReturn(new User("testUser", "1234", mockDateTime));
        when(dataAccessMock.haveGenre("testUser", "pop")).thenReturn(true);
        ArrayList<String> genres = new ArrayList<>();
        genres.add("pop");
        genres.add("rock");
        when(userMock.getGenrePreference()).thenReturn(genres);

        // Create input data with a genre that is already added
        addGenrePreferenceInputData inputData = new addGenrePreferenceInputData("pop");

        // Execute the method
        interactor.execute(inputData);

        // Verify interactions and assertions
        verify(outputBoundaryMock).prepareAddFailView("Genre already inputted.");
        verify(outputBoundaryMock, times(0)).prepareAddSuccessView(any(addGenrePreferenceOutputData.class));
        verify(outputBoundaryMock, times(0)).switchView();
    }
    }


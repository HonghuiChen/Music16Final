package use_case.deleteGenrePreference;

import entity.User;
import org.junit.jupiter.api.Test;
import use_case.deleteGenrePreference.*;


import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.mockito.Mockito.*;

public class DeleteGenrePreferenceInteractorTest {

    @Test
    void successTest() throws FileNotFoundException {
        deleteGenrePreferenceDataAccessInterface dataAccessMock = mock(deleteGenrePreferenceDataAccessInterface.class);
        deleteGenrePreferenceOutputBoundary outputBoundaryMock = mock(deleteGenrePreferenceOutputBoundary.class);

        deleteGenrePreferenceInteractor interactor = new deleteGenrePreferenceInteractor(dataAccessMock, outputBoundaryMock);

        when(dataAccessMock.readCurrUser("currentUser.txt")).thenReturn("testUser");
        when(dataAccessMock.haveGenre("testUser", "pop")).thenReturn(true);
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        when(dataAccessMock.get("testUser")).thenReturn(new User("testUser", "1234", mockDateTime));

        deleteGenrePreferenceInputData inputData = new deleteGenrePreferenceInputData("pop");

        assertDoesNotThrow(() -> interactor.execute(inputData));

        verify(outputBoundaryMock).prepareDeleteSuccessView(any(deleteGenrePreferenceOutputData.class));
        verify(outputBoundaryMock, times(0)).prepareDeleteFailView(anyString());
    }

    @Test
    void failTest() throws FileNotFoundException {
        deleteGenrePreferenceDataAccessInterface dataAccessMock = mock(deleteGenrePreferenceDataAccessInterface.class);
        deleteGenrePreferenceOutputBoundary outputBoundaryMock = mock(deleteGenrePreferenceOutputBoundary.class);

        deleteGenrePreferenceInteractor interactor = new deleteGenrePreferenceInteractor(dataAccessMock, outputBoundaryMock);

        // Mock data and behavior
        when(dataAccessMock.readCurrUser("currentUser.txt")).thenReturn("testUser");
        when(dataAccessMock.haveGenre("testUser", "pop")).thenReturn(false);

        deleteGenrePreferenceInputData inputData = new deleteGenrePreferenceInputData("pop");

        interactor.execute(inputData);

        // Verify interactions and assertions
        verify(outputBoundaryMock).prepareDeleteFailView("Genre is not in your preferences.");
        verify(outputBoundaryMock, times(0)).prepareDeleteSuccessView(any(deleteGenrePreferenceOutputData.class));
    }
}


package use_case.addGenrePreference;

import app.api.Token;
import entity.User;
import interface_adapter.GenrePreference.GenrePresenter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import use_case.addGenrePreference.*;
import use_case.login.LoginOutputBoundary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class AddGenrePreferenceInteractorTest {

    @BeforeEach
    void setUp() {
        Token.main(new String[]{""});
    }
    @Test
    void successTest() throws FileNotFoundException {
        User userMock = mock(User.class);
        addGenrePreferenceDataAccessInterface dataAccessMock = mock(addGenrePreferenceDataAccessInterface.class);
        addGenrePreferenceOutputBoundary outputBoundaryMock = mock(addGenrePreferenceOutputBoundary.class);

        addGenrePreferenceInteractor interactor =
                new addGenrePreferenceInteractor(dataAccessMock, outputBoundaryMock);

        when(dataAccessMock.readCurrUser("currentUser.txt")).thenReturn("testUser");
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        when(dataAccessMock.get("testUser")).thenReturn(new User("testUser", "1234", mockDateTime));
        when(dataAccessMock.haveGenre("testUser", "pop")).thenReturn(false);
        ArrayList<String> genres = new ArrayList<>();
        genres.add("pop");
        genres.add("rock");
        when(userMock.getGenrePreference()).thenReturn(genres);

        addGenrePreferenceInputData inputData = new addGenrePreferenceInputData("pop");

        interactor.execute(inputData);

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

        addGenrePreferenceInputData inputData = new addGenrePreferenceInputData("pop");

        interactor.execute(inputData);

        verify(outputBoundaryMock).prepareAddFailView("Genre already inputted.");
        verify(outputBoundaryMock, times(0)).prepareAddSuccessView(any(addGenrePreferenceOutputData.class));
        verify(outputBoundaryMock, times(0)).switchView();
    }

    @Test
    void invalidGenreTest() throws FileNotFoundException {
        addGenrePreferenceDataAccessInterface dataAccessMock = mock(addGenrePreferenceDataAccessInterface.class);
        addGenrePreferenceOutputBoundary outputBoundaryMock = mock(addGenrePreferenceOutputBoundary.class);

        addGenrePreferenceInteractor interactor =
                new addGenrePreferenceInteractor(dataAccessMock, outputBoundaryMock);

        when(dataAccessMock.readCurrUser("currentUser.txt")).thenReturn("testUser");
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);
        when(dataAccessMock.get("testUser")).thenReturn(new User("testUser", "1234", mockDateTime));

        addGenrePreferenceInputData inputData = new addGenrePreferenceInputData("aeiou");

        interactor.execute(inputData);

        verify(outputBoundaryMock).prepareAddFailView("This is not a valid genre.");
        verify(outputBoundaryMock, times(0)).prepareAddSuccessView(any(addGenrePreferenceOutputData.class));
        verify(outputBoundaryMock, times(0)).switchView();
    }

    @Test
    void testSwitchView() {
        addGenrePreferenceDataAccessInterface dataAccessMock = mock(addGenrePreferenceDataAccessInterface.class);
        addGenrePreferenceOutputBoundary outputBoundaryMock = mock(addGenrePreferenceOutputBoundary.class);

        addGenrePreferenceInteractor interactor =
                new addGenrePreferenceInteractor(dataAccessMock, outputBoundaryMock);

        interactor.switchView();
        verify(outputBoundaryMock).switchView();
    }

    @Test
    void testCancel() {
        addGenrePreferenceDataAccessInterface dataAccessMock = mock(addGenrePreferenceDataAccessInterface.class);
        addGenrePreferenceOutputBoundary outputBoundaryMock = mock(addGenrePreferenceOutputBoundary.class);

        addGenrePreferenceInteractor interactor =
                new addGenrePreferenceInteractor(dataAccessMock, outputBoundaryMock);

        interactor.cancel();
        verify(outputBoundaryMock).cancel();
    }
    }


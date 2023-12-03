package use_case.signup;

import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class SignupInteractorTest {

    @Test
    void successTest() {
        SignupUserDataAccessInterface dataAccessMock = mock(SignupUserDataAccessInterface.class);
        SignupOutputBoundary outputBoundaryMock = mock(SignupOutputBoundary.class);
        UserFactory userFactoryMock = mock(UserFactory.class);

        SignupInteractor interactor = new SignupInteractor(dataAccessMock, outputBoundaryMock, userFactoryMock);

        when(dataAccessMock.existsByName(anyString())).thenReturn(false);
        LocalDateTime mockDateTime = LocalDateTime.of(2015, Month.JULY, 29, 19, 30, 40);

        when(userFactoryMock.create(anyString(), anyString(), any(LocalDateTime.class))).thenReturn(new User("newUser", "password123", mockDateTime));

        SignupInputData inputData = new SignupInputData("newUser", "password123", "password123");

        // Execute the method
        assertDoesNotThrow(() -> interactor.execute(inputData));

        // Verify interactions and assertions
        verify(outputBoundaryMock).prepareSuccessView(any(SignupOutputData.class));
        verify(outputBoundaryMock, never()).prepareFailView(anyString());
        verify(outputBoundaryMock, never()).cancel();
        verify(dataAccessMock).save(any(User.class));
    }

    @Test
    void failTest() {
        SignupUserDataAccessInterface dataAccessMock = mock(SignupUserDataAccessInterface.class);
        SignupOutputBoundary outputBoundaryMock = mock(SignupOutputBoundary.class);
        UserFactory userFactoryMock = mock(UserFactory.class);

        SignupInteractor interactor = new SignupInteractor(dataAccessMock, outputBoundaryMock, userFactoryMock);

        when(dataAccessMock.existsByName(anyString())).thenReturn(true);

        SignupInputData inputData = new SignupInputData("existingUser", "password123", "password123");

        interactor.execute(inputData);

        verify(outputBoundaryMock).prepareFailView("Sorry, this user already exists.");
        verify(outputBoundaryMock, never()).prepareSuccessView(any(SignupOutputData.class));
        verify(outputBoundaryMock, never()).cancel();
        verify(dataAccessMock, never()).save(any(User.class));
    }

    @Test
    void passwordNotMatchingTest() {
        SignupUserDataAccessInterface dataAccessMock = mock(SignupUserDataAccessInterface.class);
        SignupOutputBoundary outputBoundaryMock = mock(SignupOutputBoundary.class);
        UserFactory userFactoryMock = mock(UserFactory.class);

        SignupInteractor interactor = new SignupInteractor(dataAccessMock, outputBoundaryMock, userFactoryMock);

        when(dataAccessMock.existsByName(anyString())).thenReturn(false);

        SignupInputData inputData = new SignupInputData("newUser", "password123", "differentPassword");

        interactor.execute(inputData);

        verify(outputBoundaryMock).prepareFailView("Passwords don't match, please retype.");
        verify(outputBoundaryMock, never()).prepareSuccessView(any(SignupOutputData.class));
        verify(outputBoundaryMock, never()).cancel();
        verify(dataAccessMock, never()).save(any(User.class));
    }

    @Test
    void testBlankUsername() {
        SignupUserDataAccessInterface dataAccessMock = mock(SignupUserDataAccessInterface.class);
        SignupOutputBoundary outputBoundaryMock = mock(SignupOutputBoundary.class);
        UserFactory userFactoryMock = mock(UserFactory.class);

        SignupInteractor interactor = new SignupInteractor(dataAccessMock, outputBoundaryMock, userFactoryMock);

        when(dataAccessMock.existsByName(anyString())).thenReturn(false);

        SignupInputData inputData = new SignupInputData("", "", "");

        interactor.execute(inputData);

        verify(outputBoundaryMock).prepareFailView("Username or password cannot be blank.");
        verify(outputBoundaryMock, never()).prepareSuccessView(any(SignupOutputData.class));
        verify(outputBoundaryMock, never()).cancel();
        verify(dataAccessMock, never()).save(any(User.class));
    }
    @Test
    void testSwitchView(){
        SignupUserDataAccessInterface dataAccessMock = mock(SignupUserDataAccessInterface.class);
        SignupOutputBoundary outputBoundaryMock = mock(SignupOutputBoundary.class);
        UserFactory userFactoryMock = mock(UserFactory.class);
        SignupInputBoundary signupInputBoundary = new SignupInteractor(dataAccessMock, outputBoundaryMock, userFactoryMock);

        signupInputBoundary.switchView();
        verify(outputBoundaryMock).cancel();


    }
}

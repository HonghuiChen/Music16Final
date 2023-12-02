package use_case.login;

import entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class LoginInteractorTest {

    @Mock
    private LoginUserDataAccessInterface userDataAccessInterface;
    @Mock
    private LoginOutputBoundary loginOutputBoundary;
    @Mock
    private User user;

    private LoginInteractor loginInteractor;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        loginInteractor = new LoginInteractor(userDataAccessInterface, loginOutputBoundary);
    }

    @Test
    void testSuccessfulLogin() {
        LoginInputData inputData = new LoginInputData("validUser", "correctPassword");
        when(userDataAccessInterface.existsByName("validUser")).thenReturn(true);
        when(userDataAccessInterface.get("validUser")).thenReturn(user);
        when(user.getPassword()).thenReturn("correctPassword");

        loginInteractor.execute(inputData);

        verify(loginOutputBoundary).prepareSuccessView(any(LoginOutputData.class));
    }

    @Test
    void testStoreCurrUser(){
        when(user.getUsername()).thenReturn("validUser");
        userDataAccessInterface.storeCurrUser(user.getUsername());
        verify(userDataAccessInterface).storeCurrUser("validUser");
    }

    @Test
    void testNonExistentUser() {
        LoginInputData inputData = new LoginInputData("invalidUser", "password");
        when(userDataAccessInterface.existsByName("invalidUser")).thenReturn(false);

        loginInteractor.execute(inputData);

        verify(loginOutputBoundary).prepareFailView("invalidUser: Account does not exist.");
    }

    @Test
    void testIncorrectPassword() {
        LoginInputData inputData = new LoginInputData("validUser", "wrongPassword");
        when(userDataAccessInterface.existsByName("validUser")).thenReturn(true);
        when(userDataAccessInterface.get("validUser")).thenReturn(user);
        when(user.getPassword()).thenReturn("correctPassword");

        loginInteractor.execute(inputData);

        verify(loginOutputBoundary).prepareFailView("Incorrect password for validUser.");
    }

    @Test
    void testSwitchView() {
        loginInteractor.switchView();
        verify(loginOutputBoundary).cancel();
    }
}
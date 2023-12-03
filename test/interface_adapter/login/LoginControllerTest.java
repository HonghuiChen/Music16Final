package interface_adapter.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LoginControllerTest {
    private LoginInputBoundary loginUseCaseInteractor;
    private LoginController loginController;

    @BeforeEach
    void setUp() {
        // Create a mock for the LoginInputBoundary interface
        loginUseCaseInteractor = mock(LoginInputBoundary.class);

        // Initialize the LoginController with the mock LoginInputBoundary
        loginController = new LoginController(loginUseCaseInteractor);
    }

    @Test
    void cancelShouldCallSwitchView() {
        // Call the cancel method
        loginController.cancel();

        // Verify that the switchView method of the mock LoginInputBoundary was called
        verify(loginUseCaseInteractor, times(1)).switchView();
    }


//    void executeTest() {
//    }

//    @Test
//    void executeShouldCallStoreCurrUserAndExecute() {
//        // Define input parameters
//        String username = "testUser";
//        String password = "testPassword";
//
//        // Call the execute method
//        loginController.execute(username, password);
//
//        // Verify that the storeCurrUser and execute methods of the mock LoginInputBoundary were called
//        verify(loginUseCaseInteractor, times(1)).storeCurrUser(username);
//
//        // Create an expected LoginInputData object based on the input parameters
//        LoginInputData expectedLoginInputData = new LoginInputData(username, password);
//
//        // Verify that the execute method of the mock LoginInputBoundary was called with the expected input data
//        verify(loginUseCaseInteractor, times(1)).execute(eq(expectedLoginInputData));
//    }

}
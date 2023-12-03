package interface_adapter.signup;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import interface_adapter.signup.SignupController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import static org.mockito.Mockito.*;

class SignupControllerTest {

    @Mock
    private SignupInputBoundary mockSignupInteractor;

    private SignupController signupController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signupController = new SignupController(mockSignupInteractor);
    }

    @Test
    void testExecute() {
        String username = "user";
        String password1 = "pass1";
        String password2 = "pass2";

        signupController.execute(username, password1, password2);

        verify(mockSignupInteractor).execute(any(SignupInputData.class));
    }

    @Test
    void testCancel() {
        signupController.cancel();

        verify(mockSignupInteractor).switchView();
    }
}

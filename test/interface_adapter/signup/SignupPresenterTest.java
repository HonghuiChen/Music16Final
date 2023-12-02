import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupPresenter;
import interface_adapter.signup.SignupState;
import interface_adapter.signup.SignupViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.signup.SignupOutputData;

import java.time.LocalDateTime;

import static org.mockito.Mockito.*;

class SignupPresenterTest {
    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private SignupViewModel mockSignupViewModel;
    @Mock
    private LoginViewModel mockLoginViewModel;

    private SignupPresenter signupPresenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        signupPresenter = new SignupPresenter(mockViewManagerModel, mockSignupViewModel, mockLoginViewModel);
    }

    @Test
    void testPrepareSuccessView() {
        SignupOutputData response = new SignupOutputData("username", LocalDateTime.now().toString(), false);
        LoginState loginState = new LoginState();
        when(mockLoginViewModel.getState()).thenReturn(loginState);
        signupPresenter.prepareSuccessView(response);

        verify(mockLoginViewModel).setState(any(LoginState.class));
        verify(mockLoginViewModel).firePropertyChanged();
        verify(mockViewManagerModel).setActiveView(mockLoginViewModel.getViewName());
        verify(mockViewManagerModel).firePropertyChanged();
        verify(mockSignupViewModel).firePropertyChanged();
    }

    @Test
    void testPrepareFailView() {
        String error = "Error message";
        SignupState signupState = new SignupState();
        when(mockSignupViewModel.getState()).thenReturn(signupState);
        signupPresenter.prepareFailView(error);

        verify(mockSignupViewModel).getState();
        verify(mockSignupViewModel).firePropertyChanged();
    }

    @Test
    void testCancel() {
        signupPresenter.cancel();

        verify(mockViewManagerModel).setActiveView(mockLoginViewModel.getViewName());
        verify(mockViewManagerModel).firePropertyChanged();
    }
}

package interface_adapter.homeScreen;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.logout.LogoutInteractor;

import static org.mockito.Mockito.verify;

class LogoutControllerTest {
    @Mock
    LogoutInteractor logoutInteractor;
    @Test
    void execute() {
        MockitoAnnotations.openMocks(this);
        LogoutController logoutController = new LogoutController(logoutInteractor);
        logoutController.execute();
        verify(logoutInteractor).execute();
    }
}
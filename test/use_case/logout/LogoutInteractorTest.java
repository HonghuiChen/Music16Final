package use_case.logout;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class LogoutInteractorTest {

    @Mock
    LogoutOutputBoundary logoutPresenter;
    @Test
    void testExecute() {
        MockitoAnnotations.openMocks(this);
        LogoutInteractor logoutInteractor = new LogoutInteractor(logoutPresenter);
        logoutInteractor.execute();
        verify(logoutPresenter).prepareSuccessView();
    }
}
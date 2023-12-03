package interface_adapter.signup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class SignupViewModelTest {

    private SignupViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new SignupViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void testInitialState() {
        SignupState initialState = viewModel.getState();
        assertNotNull(initialState, "Initial state should not be null");
    }

    @Test
    void testSetState() {
        SignupState newState = new SignupState();
        newState.setUsername("testUser");
        newState.setPassword("testPass");

        viewModel.setState(newState);
        viewModel.firePropertyChanged();

        assertEquals(newState, viewModel.getState(), "State should be updated to the new state");
        verify(mockListener).propertyChange(any());
    }

    @Test
    void testFirePropertyChanged() {
        SignupState newState = new SignupState();
        viewModel.setState(newState);

        viewModel.firePropertyChanged();

        verify(mockListener).propertyChange(any());
    }
}

package interface_adapter.GenrePreference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class GenreViewModelTest {

    private GenreViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp() {
        viewModel = new GenreViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void testInitialState() {
        GenreState initialState = viewModel.getState();
        assertNotNull(initialState, "Initial state should not be null");
    }

    @Test
    void testSetState() {
        GenreState newState = new GenreState();
        newState.setGenre("testGenre");

        viewModel.setState(newState);
        viewModel.firePropertyChanged();

        assertEquals(newState, viewModel.getState(), "State should be updated to the new state");
        verify(mockListener).propertyChange(any());
    }

    @Test
    void testFirePropertyChanged() {
        GenreState newState = new GenreState();
        viewModel.setState(newState);

        viewModel.firePropertyChanged();

        verify(mockListener).propertyChange(any());
    }}
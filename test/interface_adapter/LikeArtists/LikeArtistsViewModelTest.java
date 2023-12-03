package interface_adapter.LikeArtists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LikeArtistsViewModelTest {
    private LikeArtistsViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp(){
    viewModel = new LikeArtistsViewModel();
    mockListener = mock(PropertyChangeListener.class);
    viewModel.addPropertyChangeListener(mockListener);
}

    @Test
    void testInitialState(){
        LikeArtistsState initialState = viewModel.getState();
        assertNotNull(initialState, "Initial state should not be null");
    }

    @Test
    void testlikeArtist(){
        LikeArtistsState newState = new LikeArtistsState();
        newState.likeArtist("Adele");
        viewModel.setState(newState);
        viewModel.firePropertyChanged();

        assertEquals(newState, viewModel.getState(), "State should be updated to the new state" );
        verify(mockListener).propertyChange(any());
    }

    @Test
    void testunlikeArtist(){
        LikeArtistsState newState = new LikeArtistsState();
        newState.unlikeArtist("Adele");
        viewModel.setState(newState);
        viewModel.firePropertyChanged();

        assertEquals(newState, viewModel.getState(), "State should be updated to the new state" );
        verify(mockListener).propertyChange(any());
    }

    @Test
    void testFirePropertyChanged() {
        LikeArtistsState newState = new LikeArtistsState();
        viewModel.setState(newState);

        viewModel.firePropertyChanged();

        verify(mockListener).propertyChange(any());
    }


}



package interface_adapter.LikeTracks;
import interface_adapter.LikeArtists.LikeArtistsState;
import interface_adapter.LikeArtists.LikeArtistsViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.beans.PropertyChangeListener;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LikeTracksViewModelTest {
    private LikeTracksViewModel viewModel;
    private PropertyChangeListener mockListener;

    @BeforeEach
    void setUp(){
        viewModel = new LikeTracksViewModel();
        mockListener = mock(PropertyChangeListener.class);
        viewModel.addPropertyChangeListener(mockListener);
    }

    @Test
    void testInitialState(){
        LikeTracksState initialState = viewModel.getState();
        assertNotNull(initialState, "Initial state should not be null");
    }

    @Test
    void testlikeArtist(){
        LikeTracksState newState = new LikeTracksState();
        newState.likeTrack("Hello");
        viewModel.setState(newState);
        viewModel.firePropertyChanged();

        assertEquals(newState, viewModel.getState(), "State should be updated to the new state" );
        verify(mockListener).propertyChange(any());
    }

    @Test
    void testunlikeArtist(){
        LikeTracksState newState = new LikeTracksState();
        newState.unlikeTrack("Hello");
        viewModel.setState(newState);
        viewModel.firePropertyChanged();

        assertEquals(newState, viewModel.getState(), "State should be updated to the new state" );
        verify(mockListener).propertyChange(any());
    }

    @Test
    void testFirePropertyChanged() {
        LikeTracksState newState = new LikeTracksState();
        viewModel.setState(newState);

        viewModel.firePropertyChanged();

        verify(mockListener).propertyChange(any());
    }


}

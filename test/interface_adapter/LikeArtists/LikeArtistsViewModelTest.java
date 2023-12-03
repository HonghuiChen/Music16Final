package interface_adapter.LikeArtists;
import interface_adapter.LikeTracks.LikeTracksViewModel;
import org.junit.jupiter.api.Test;
import use_case.LikeArtists.LikeArtistsOutputData;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LikeArtistsViewModelTest {

    @Test
    public void SuccessTest(){
        LikeArtistsViewModel viewModel = new LikeArtistsViewModel();
        LikeArtistsState state = new LikeArtistsState();
        viewModel.setState(state);
        assertEquals(viewModel.getState(), state);
    }
}

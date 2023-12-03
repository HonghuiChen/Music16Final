package interface_adapter.LikeTracks;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LikeTracksViewModelTest {
    @Test
    public void SuccessTest(){
        LikeTracksViewModel viewModel = new LikeTracksViewModel();
        LikeTracksState state = new LikeTracksState();
        viewModel.setState(state);
        assertEquals(viewModel.getState(), state);
    }
}

package interface_adapter.LikeTracks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.LikeTracks.LikeTracksInputBoundary;
import use_case.LikeTracks.LikeTracksInputData;
import use_case.LikeTracks.LikeTracksInteractor;
import java.io.IOException;

import static org.mockito.Mockito.*;


public class LikeTracksControllerTest {
    @Mock
    private LikeTracksInputBoundary likeTracksInteractor;
    private LikeTracksController likeTracksController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        likeTracksController = new LikeTracksController(likeTracksInteractor);
    }

    @Test
    void testLike() throws IOException {
        likeTracksController.like("august");
        verify(likeTracksInteractor, times(1)).like(any(LikeTracksInputData.class));
    }
    @Test
    void testUnlike() throws IOException {
        likeTracksController.unlike("august");
        verify(likeTracksInteractor, times(1)).unlike(any(LikeTracksInputData.class));
    }
}

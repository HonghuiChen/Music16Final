package interface_adapter.LikeArtists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.LikeArtists.LikeArtistsInputBoundary;
import use_case.LikeArtists.LikeArtistsInputData;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class LikeArtistsControllerTest {
    @Mock
    private LikeArtistsInputBoundary likeArtistsInteractor;
    private LikeArtistsController likeArtistsController;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        likeArtistsController = new LikeArtistsController(likeArtistsInteractor);
    }

    @Test
    void testLike() throws IOException{
        likeArtistsController.like("Adele");
        verify(likeArtistsInteractor, times(1)).like(any(LikeArtistsInputData.class));
    }
    @Test
    void testUnlike() throws IOException{
        likeArtistsController.unlike("Adele");
        verify(likeArtistsInteractor, times(1)).unlike(any(LikeArtistsInputData.class));
    }
}

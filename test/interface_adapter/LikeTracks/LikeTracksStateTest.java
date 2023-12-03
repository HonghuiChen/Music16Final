package interface_adapter.LikeTracks;
import static org.junit.jupiter.api.Assertions.*;

import interface_adapter.LikeArtists.LikeArtistsState;
import org.junit.jupiter.api.Test;

public class LikeTracksStateTest {
    @Test
    public void initialStateTest(){
        LikeTracksState state = new LikeTracksState();
        assertEquals(state.getTrack(), "");
    }
    @Test
    public void likeTracksTest(){
        LikeTracksState state = new LikeTracksState();
        state.likeTrack("lowkey");
        assertEquals(state.getTrack(), "lowkey");
    }
    @Test
    public void unlikeTrackTest(){
        LikeTracksState state = new LikeTracksState();
        state.unlikeTrack("lowkey");
        assertNull(state.getTrack());
    }
    @Test
    public void likeErrorTest(){
        LikeTracksState state = new LikeTracksState();
        state.likeTrackError(null);
        assertNull(state.getLikeTrackError());
    }


}

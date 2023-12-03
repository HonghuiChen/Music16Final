package interface_adapter.LikeArtists;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LikeArtistsStateTest {
    @Test
    public void initialStateTest(){
        LikeArtistsState state = new LikeArtistsState();
        assertEquals(state.getArtists(), "");
    }

    @Test
    public void likeArtistTest(){
        LikeArtistsState state = new LikeArtistsState();
        state.likeArtist("The 1975");
        assertEquals(state.getArtists(), "The 1975");
    }

    @Test
    public void unlikeArtistTest(){
        LikeArtistsState state = new LikeArtistsState();
        state.unlikeArtist("The 1975");
        assertNull(state.getArtists());
    }
    @Test
    public void likeErrorTest(){
        LikeArtistsState state = new LikeArtistsState();
        state.likeArtistError(null);
        assertNull(state.getLikeArtistsError());
    }

    @Test
    void testCopyConstructor(){
        LikeArtistsState original = new LikeArtistsState();
        original.likeArtist("NIKI");
        original.likeArtistError(null);

        LikeArtistsState copy = new LikeArtistsState(original);
        assertEquals("NIKI", copy.getArtists());
        assertNull(copy.getLikeArtistsError());
    }


}

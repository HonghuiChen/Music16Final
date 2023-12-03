package use_case.LikeTracks;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LikeTracksOutputDataTest {
    LikeTracksOutputData likeTracksOutputData = new LikeTracksOutputData("lowkey", false);

    @Test
    void getSong(){
        assertEquals("lowkey", likeTracksOutputData.getSong());
    }
}

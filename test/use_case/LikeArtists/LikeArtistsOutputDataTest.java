package use_case.LikeArtists;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class LikeArtistsOutputDataTest {
    LikeArtistsOutputData output = new LikeArtistsOutputData("NIKI", false);
    @Test
    void getArtist(){
        assertEquals("NIKI", output.getArtists());
    }
}



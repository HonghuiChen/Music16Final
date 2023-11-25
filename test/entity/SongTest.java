package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    @Test
    void testConstructorAndGetters() {
        Song song = new Song("Shape of You", "Ed Sheeran", "Divide", "some_url");
        assertEquals("Shape of You", song.getName());
        assertEquals("Ed Sheeran", song.getArtist());
        assertEquals("Divide", song.getAlbum());
        assertEquals("some_url", song.getUrl());
    }

    @Test
    void testAddComments() {
        Song song = new Song("Yesterday", "The Beatles", "Help!", "another_url");
        song.addComments("Great song!");
        song.addComments("My favorite Beatles track.");
        assertTrue(song.getComments().contains("Great song!"));
        assertTrue(song.getComments().contains("My favorite Beatles track."));
    }

    @Test
    void testNullValuesInConstructor() {
        assertDoesNotThrow(() -> new Song(null, null, null, null));
    }

    @Test
    void testAddNullComment() {
        Song song = new Song("Lose Yourself", "Eminem", "8 Mile", "url_here");
        assertDoesNotThrow(() -> song.addComments(null));
        // Further assertions can be added based on how null comments should be handled
    }
}
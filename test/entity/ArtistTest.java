package entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ArtistTest {

    @Test
    void testArtistInitialization() {
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("Album1", "Artist1", "Genre1", new Song[0]));
        albums.add(new Album("Album2", "Artist2", "Genre2", new Song[0]));
        Artist artist = new Artist("ArtistName", albums);

        assertEquals("ArtistName", artist.getName(), "Artist name should match the one provided");
        assertEquals(albums, artist.getAlbums(), "Artist albums should match the ones provided");
    }

    @Test
    void testGetName() {
        Artist artist = new Artist("ArtistName", new ArrayList<>());
        assertEquals("ArtistName", artist.getName(), "getName should return the correct artist name");
    }

    @Test
    void testGetAlbums() {
        ArrayList<Album> albums = new ArrayList<>();
        albums.add(new Album("AlbumName", "ArtistName", "GenreName", new Song[0]));
        Artist artist = new Artist("ArtistName", albums);
        assertEquals(albums, artist.getAlbums(), "getAlbums should return the correct list of albums");
    }
}
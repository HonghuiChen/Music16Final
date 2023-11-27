package entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlbumTest {

        @Test
        void testAlbumInitialization() {
            Song[] songs = {new Song("Song1", "Artist1", "Album1", "URL1"),
                    new Song("Song2", "Artist2", "Album2", "URL2")};
            Album album = new Album("TestAlbum", "TestArtist", "TestGenre", songs);

            assertEquals("TestAlbum", album.getName(), "Album name should match the one provided");
            assertEquals("TestArtist", album.getArtist(), "Album artist should match the one provided");
            assertEquals("TestGenre", album.getGenre(), "Album genre should match the one provided");
            assertArrayEquals(songs, album.getSongs(), "Album songs should match the ones provided");
        }

        @Test
        void testGetName() {
            Album album = new Album("AlbumName", "ArtistName", "GenreName", new Song[0]);
            assertEquals("AlbumName", album.getName(), "getName should return the correct album name");
        }

        @Test
        void testGetArtist() {
            Album album = new Album("AlbumName", "ArtistName", "GenreName", new Song[0]);
            assertEquals("ArtistName", album.getArtist(), "getArtist should return the correct artist name");
        }

        @Test
        void testGetGenre() {
            Album album = new Album("AlbumName", "ArtistName", "GenreName", new Song[0]);
            assertEquals("GenreName", album.getGenre(), "getGenre should return the correct genre");
        }

        @Test
        void testGetSongs() {
            Song[] songs = {new Song("Song1", "Artist1", "Album1", "URL1")};
            Album album = new Album("AlbumName", "ArtistName", "GenreName", songs);
            assertArrayEquals(songs, album.getSongs(), "getSongs should return the correct array of songs");
        }
}
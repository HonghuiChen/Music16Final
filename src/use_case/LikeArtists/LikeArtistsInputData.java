package use_case.LikeArtists;

public class LikeArtistsInputData {
    final private String artist;
    public LikeArtistsInputData(String artist) {
        this.artist = artist;
    }
    String getArtist(){
        return artist;
    }
}

package use_case.LikeArtists;

public class LikeArtistsOutputData {
    private final String artist;
    private boolean useCaseFailed;
    public LikeArtistsOutputData(String artist, boolean useCaseFailed) {
        this.artist = artist;
        this.useCaseFailed = useCaseFailed;
    }
    public String getArtists(){
        return artist;
    }

}

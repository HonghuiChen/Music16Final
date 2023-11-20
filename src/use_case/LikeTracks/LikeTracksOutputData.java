package use_case.LikeTracks;

public class LikeTracksOutputData {
    private final String song;
    private boolean useCaseFailed;
    public LikeTracksOutputData(String song, boolean useCaseFailed) {
        this.song = song;
        this.useCaseFailed = useCaseFailed;
    }

}

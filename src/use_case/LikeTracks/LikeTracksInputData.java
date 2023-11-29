package use_case.LikeTracks;

public class LikeTracksInputData {
    final private String song;
    public LikeTracksInputData(String song) {
        this.song = song;
    }
    static String getSong(){
        return song;
    }
}

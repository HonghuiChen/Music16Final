package interface_adapter.LikeTracks;


public class LikeTracksState {
    private String track = "";
    private String likeTrackError = null;

    public LikeTracksState(LikeTracksState copy){
        this.track = copy.track;
        this.likeTrackError = copy.likeTrackError;
    }
    public LikeTracksState(){}

    public String getTrack(){ return track; }
    public String getLikeTrackError(){ return likeTrackError; }
    public void likeTrackError(String likeTrackError){ this.likeTrackError = likeTrackError;}
    public void likeTrack(String track) {this.track = track;}
    public void unlikeTrack(String track) {this.track = null;}




}
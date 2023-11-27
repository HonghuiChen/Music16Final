package interface_adapter.LikeArtists;

import entity.User;

public class LikeArtistsState {
    private String artist = "";
    private String likeArtistsError = null;

    public LikeArtistsState(LikeArtistsState copy){
        this.artist = copy.artist;
        this.likeArtistsError = copy.likeArtistsError;

    }
    public LikeArtistsState(){}

    public String getArtists(){
        return artist;
    }
    public String getLikeArtistsError(){
        return likeArtistsError;
    }

    public void likeArtistError(String likeArtistsError) {
        this.likeArtistsError = likeArtistsError;
    }
    public void likeArtist(String artist){
        this.artist = artist;
    }

    public void unlikeArtist(String artist){
        this.artist = null;
    }



}

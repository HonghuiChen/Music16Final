package use_case.SearchArtist;

import use_case.signup.SignupOutputData;

import java.util.ArrayList;

public class SearchArtistOutputData {
    private String artistName;
    private ArrayList<String> genres;
    private String followers;

    public SearchArtistOutputData(String artistName, ArrayList<String> genres, String followers) {
        this.artistName = artistName;
        this.genres = genres;
        this.followers = followers;
    }

    public String getArtistName() {
        return artistName;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public String getFollowers() {
        return followers;
    }

    //Searched Time?

}

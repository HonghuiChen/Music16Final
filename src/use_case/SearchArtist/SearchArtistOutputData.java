package use_case.SearchArtist;

import use_case.signup.SignupOutputData;

import java.util.ArrayList;

public class SearchArtistOutputData {
    private String artistName;
    private ArrayList<String> genres;
    private String followers;



    private ArrayList<String> output = new ArrayList<>();

    public SearchArtistOutputData(String artistName, ArrayList<String> genres, String followers) {
        this.artistName = artistName;
        this.genres = genres;
        this.followers = followers;

        String gens = arrayListToString(genres);
        output.add(artistName);
        output.add(gens);
        output.add(followers);
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

    public ArrayList<String> getOutput() {
        return output;
    }

    //Searched Time?

    private static String arrayListToString(ArrayList<String> list) {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < list.size(); i++) {
            result.append(list.get(i));
            if (i < list.size() - 1) {
                result.append(", ");
            }
        }
        result.append("]");
        return result.toString();
    }

}

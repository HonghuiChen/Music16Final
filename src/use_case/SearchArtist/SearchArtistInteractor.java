package use_case.SearchArtist;

import app.api.Token;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

public class SearchArtistInteractor implements SearchArtistInputBoundary{
    private static final String API_URL_Search = "https://api.spotify.com/v1/search";
    private static final String API_URL_Get_Artist = "https://api.spotify.com/v1/artists";
    // Read token from token.txt
    private static String API_TOKEN;

    final SearchArtistOutputBoundary searchArtistPresenter;

    static {
        try {
            API_TOKEN = Token.get_auth();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public SearchArtistInteractor(SearchArtistOutputBoundary searchArtistOutputBoundary) {
        this.searchArtistPresenter = searchArtistOutputBoundary;
    }


    public void execute(SearchArtistInputData searchArtistInputData) throws IOException, JSONException {
        // API call to get Artist ID.
        OkHttpClient searchClient = new OkHttpClient().newBuilder()
                .build();
        // MAKE MARKET CA?
        Request searchRequest = new Request.Builder()
                .url(String.format("%s?q=%s&type=%s", API_URL_Search, searchArtistInputData.getQuery(), "artist"))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response searchResponse = searchClient.newCall(searchRequest).execute();
        // System.out.println(response);
        JSONObject searchResponseBody = new JSONObject(searchResponse.body().string());

        if (searchResponseBody.getJSONObject("artists").getJSONArray("items").isEmpty()) {
            searchArtistPresenter.prepareFailView("Artist not exist.");
        }
        else {
            String artistID = searchResponseBody.getJSONObject("artists").getJSONArray("items")
                    .getJSONObject(0).getString("id");

            // get artist API call to get Artist's name, genre, followers.
            OkHttpClient getArtistClient = new OkHttpClient().newBuilder()
                    .build();
            Request getArtistRequest = new Request.Builder()
                    .url(String.format("%s/%s", API_URL_Get_Artist, artistID))
                    .addHeader("Authorization", API_TOKEN)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response getArtistResponse = getArtistClient.newCall(getArtistRequest).execute();
            JSONObject getArtistResponseBody = new JSONObject(getArtistResponse.body().string());

            String artistName = getArtistResponseBody.getString("name");

            JSONArray genresArray = getArtistResponseBody.getJSONArray("genres");
            ArrayList<String> artistGenres = new ArrayList<>();
            for (int i = 0; i < genresArray.length(); i++) {
                artistGenres.add(genresArray.getString(i));
            }

            Integer intArtistNumFollowers = getArtistResponseBody.getJSONObject("followers").getInt("total");

            String artistNumFollowers = intArtistNumFollowers.toString();

            // For Testing
            System.out.println(artistName);
            for (String genre: artistGenres) {
                System.out.println(genre);
            }
            System.out.println(artistNumFollowers);

            SearchArtistOutputData searchArtistOutputData =
                    new SearchArtistOutputData(artistName, artistGenres, artistNumFollowers);

            searchArtistPresenter.prepareSuccessView(searchArtistOutputData);
        }
        // Search then stored data in a searchedArtist data file
        // So User can then like the artist with the data
    }

    // For testing
//    public static void main(String[] args) throws IOException {
//        //SearchArtistInteractor sa = new SearchArtistInteractor();
//        //sa.execute(new SearchArtistInputData("Eminem"));
//    }

}


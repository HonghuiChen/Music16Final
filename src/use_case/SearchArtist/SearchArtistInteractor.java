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

    static {
        try {
            API_TOKEN = Token.get_auth();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // Design to return the Artist spotify ID.
    public void searchArtist(SearchArtistInputData searchArtistInputData) throws IOException, JSONException {
        OkHttpClient searchClient = new OkHttpClient().newBuilder()
                .build();
        //MAKE MARKET CA?
        Request searchRequest = new Request.Builder()
                .url(String.format("%s?q=%s&type=%s", API_URL_Search, searchArtistInputData.getQuery(), "artist"))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response searchResponse = searchClient.newCall(searchRequest).execute();
        // System.out.println(response);
        JSONObject searchResponseBody = new JSONObject(searchResponse.body().string());

        if (searchResponseBody.getJSONObject("artists").getJSONArray("items").isEmpty()) {
            //PrepareFailView
        }
        else {
            String artistID = searchResponseBody.getJSONObject("artists").getJSONArray("items")
                    .getJSONObject(0).getString("id");

            // get artist API call to get Artist's name, genre, followers.

            OkHttpClient GetArtistClient = new OkHttpClient().newBuilder()
                    .build();
            Request GetArtistRequest = new Request.Builder()
                    .url(String.format("%s/%s", API_URL_Get_Artist, artistID))
                    .addHeader("Authorization", API_TOKEN)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response GetArtistResponse = searchClient.newCall(searchRequest).execute();
            JSONObject GetArtistResponseBody = new JSONObject(searchResponse.body().string());

            String artistName = GetArtistResponseBody.getString("name");
            JSONArray genresArray = GetArtistResponseBody.getJSONArray("genres");

            ArrayList<String> artistGenres = new ArrayList<>();
            for (int i = 0; i < genresArray.length(); i++) {
                artistGenres.add(genresArray.getString(i));
            }

            String ArtistNumFollowers = GetArtistResponseBody.getJSONObject("followers").getString("total");

        }


    }



}

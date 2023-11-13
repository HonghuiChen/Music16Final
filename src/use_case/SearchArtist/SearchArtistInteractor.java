package use_case.SearchArtist;

import app.api.Token;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

public class SearchArtistInteractor implements SearchArtistInputBoundary{
    private static final String API_URL = "https://api.spotify.com/v1/search";
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
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("%s?q=%s&type=%s", API_URL, searchArtistInputData.getQuery(), "artist"))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        // System.out.println(response);
        JSONObject responseBody = new JSONObject(response.body().string());

        String aritistId = responseBody.getJSONObject("artists").getJSONArray("items")
                .getJSONObject(0).getString("id");

        // return aritistId;
        //TODO: decide what artist data to return then write code for another API call with the aritistId.

    }

}

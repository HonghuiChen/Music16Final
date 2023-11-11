package use_case.SearchAritist;

import app.api.Token;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import use_case.SearchTrack.SearchTrack;

import java.io.IOException;
import java.util.ArrayList;

public class SearchArtist {
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
    public String searchArtist(String query) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("%s?q=%s&type=%s", API_URL, query, "artist"))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        // System.out.println(response);
        JSONObject responseBody = new JSONObject(response.body().string());

        String aritistId = responseBody.getJSONObject("artists").getJSONArray("items")
                .getJSONObject(0).getString("id");

        return aritistId;
    }

    public static void main(String[] args) throws IOException {
        SearchArtist sa = new SearchArtist();
        System.out.println(sa.searchArtist("Eminem"));
    }
}

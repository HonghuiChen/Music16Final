package use_case;

import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import api.Token;

import java.io.IOException;
import java.util.ArrayList;

public class SearchTrack {
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

    public ArrayList searchTrack(String query, String type) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("%s?q=%s&type=%s", API_URL, query, type))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);
        JSONObject responseBody = new JSONObject(response.body().string());
        JSONArray items = responseBody.getJSONObject("tracks").getJSONArray("items");
        ArrayList result = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            String song = items.getJSONObject(i).getString("name");
            String artist = items.getJSONObject(i).getJSONArray("artists").getJSONObject(0).getString("name");
            result.add(song + " - " + artist);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        SearchTrack db = new SearchTrack();
        ArrayList result = db.searchTrack("Evangeline", "track");
        try {
            for (Object x : result) {
                System.out.println(x);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

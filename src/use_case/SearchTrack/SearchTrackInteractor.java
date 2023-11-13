package use_case.SearchTrack;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import app.api.Token;

import java.io.IOException;
import java.util.ArrayList;

public class SearchTrackInteractor implements SearchTrackInputBoundary{
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

    public void search(SearchTrackInputData inputData) throws IOException, JSONException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("%s?q=%s&type=%s", API_URL, inputData.getQuery(), "track"))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response);
        JSONObject responseBody = new JSONObject(response.body().string());
        JSONArray items = responseBody.getJSONObject("tracks").getJSONArray("items");

        //The array list that will store the results of the search
        ArrayList result = new ArrayList<>();
        for (int i = 0; i < items.length(); i++) {
            String song = items.getJSONObject(i).getString("name");
            String artist = items.getJSONObject(i).getJSONArray("artists").getJSONObject(0).getString("name");
            result.add(song + " - " + artist);
        }
        SearchTrackOutputData outputData = new SearchTrackOutputData(result);
        //TODO create a presenter and pass the output data to it
        //TODO then call the presenter prepSuccessView() method
    }

}

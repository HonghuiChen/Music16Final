package use_case.SearchTrack;
import interface_adapter.homeScreen.HomeScreenPresenter;
import okhttp3.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import app.api.Token;
import use_case.signup.SignupOutputBoundary;

import java.io.IOException;
import java.util.ArrayList;

public class SearchTrackInteractor implements SearchTrackInputBoundary{
    final HomeScreenPresenter homeScreenPresenter;
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

    public SearchTrackInteractor(HomeScreenPresenter homeScreenPresenter) {
        this.homeScreenPresenter = homeScreenPresenter;
    }

    public void search(SearchTrackInputData inputData) throws IOException, JSONException {

        try {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .build();
            Request request = new Request.Builder()
                    .url(String.format("%s?q=%s&type=%s", API_URL, inputData.getQuery(), "track"))
                    .addHeader("Authorization", API_TOKEN)
                    .addHeader("Content-Type", "application/json")
                    .build();
            Response response = client.newCall(request).execute();
            System.out.println(response);

            if (!response.isSuccessful()) try {
                throw new IOException("Unexpected code " + response);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            JSONObject responseBody = new JSONObject(response.body().string());
            JSONArray items = responseBody.getJSONObject("tracks").getJSONArray("items");

            // The array list that will store the results of the search
            ArrayList<String> result = new ArrayList<>();
            for (int i = 0; i < items.length(); i++) {
                String song = items.getJSONObject(i).getString("name");
                String artist = items.getJSONObject(i).getJSONArray("artists").getJSONObject(0).getString("name");
                result.add(song + " - " + artist);
            }
            SearchTrackOutputData outputData = new SearchTrackOutputData(result);

            // TODO create a presenter and pass the output data to it
            homeScreenPresenter.prepareSuccessView(outputData);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle network errors or unsuccessful response
            homeScreenPresenter.prepareFailView("Network error");
        } catch (JSONException e) {
            e.printStackTrace();
            // Handle JSON parsing errors
            homeScreenPresenter.prepareFailView("JSON parsing error");
        }
    }

}

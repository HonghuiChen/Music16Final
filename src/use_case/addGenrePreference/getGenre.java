package use_case.addGenrePreference;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import app.api.Token;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;

// SRP Example : This class' responsibility is only calling API to get Available/Valid Genres.
public class getGenre {
    private static final String API_URL = "https://api.spotify.com/v1/recommendations/available-genre-seeds";
    private static String API_TOKEN;
    private static ArrayList<String> availableGenres;

    static {
        try {
            API_TOKEN = Token.get_auth();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void initAvailableGenres() {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Authorization", API_TOKEN)
                .build();

        try {
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                String responseBody = response.body();

                availableGenres = parseAvailableGenres(responseBody);

            } else {
                System.err.println("Error: " + response.statusCode() + ", " + response.body());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> parseAvailableGenres(String responseBody) {
        ArrayList<String> availableGenres = new ArrayList<>();

        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray genresArray = jsonObject.getJSONArray("genres");

        for (int i = 0; i < genresArray.length(); i++) {
            String genre = genresArray.getString(i);
            availableGenres.add(genre);
        }
        return availableGenres;
    }

    public static ArrayList<String> getAvailableGenres() {
        return availableGenres;
    }
}
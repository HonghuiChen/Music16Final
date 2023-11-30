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
    public static void main(String[] args) {
        // Create an HTTP client
        HttpClient httpClient = HttpClient.newHttpClient();

        // Build the request with the access token in the Authorization header
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .header("Authorization", API_TOKEN)
                .build();

        try {
            // Send the request and get the response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Check if the request was successful (status code 200)
            if (response.statusCode() == 200) {
                // Get the response body
                String responseBody = response.body();

                // Parse the JSON response and store information in an ArrayList
                availableGenres = parseAvailableGenres(responseBody);

                // Print the genre seeds
                System.out.println("Available Genres:");
                for (String genre : availableGenres) {
                    System.out.println(genre);
                }

            } else {
                // Print an error message if the request was not successful
                System.err.println("Error: " + response.statusCode() + ", " + response.body());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<String> parseAvailableGenres(String responseBody) {
        ArrayList<String> availableGenres = new ArrayList<>();

        // Parse the JSON response
        JSONObject jsonObject = new JSONObject(responseBody);
        JSONArray genresArray = jsonObject.getJSONArray("genres");

        // Extract information about available genre seeds
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
package use_case.SearchTrack;
import app.api.Token;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;

public class GetTrack{
    private static final String API_URL = "https://api.spotify.com/v1/tracks";
    private static String API_TOKEN;

    //retrieve the api token
    static {
        try {
            Token.main(null);
            API_TOKEN = Token.get_auth();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //takes in the track id and returns a map that stores the track name, the album name and the artists names.
    //can be modified to store the ids instead of names.
    //not meant to be output, need to structure a String if ever needed.
    public static HashMap<String, Object> getTrack(String id) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();
        Request request = new Request.Builder()
                .url(String.format("%s/%s", API_URL, id))
                .addHeader("Authorization", API_TOKEN)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = client.newCall(request).execute();
        JSONObject responseBody = new JSONObject(response.body().string());
        String trackName = responseBody.getString("name");
        String albumName = responseBody.getJSONObject("album").getString("name");
        JSONArray artists = responseBody.getJSONArray("artists");
        String[] artistsNames = new String[artists.length()];
        for (int i = 0; i < artists.length(); i++) {
            artistsNames[i] = artists.getJSONObject(i).getString("name");
        }
        map.put("track name", trackName);
        map.put("album name", albumName);
        map.put("artists names", artistsNames);
        //parse the array to String instead if you ever need to output the map as a String for better visualization
        //map.put("artists names", Arrays.toString(artistsNames));
        return map;
    }

    public static void main(String[] args) {
        try {
            System.out.println(getTrack("11dFghVXANMlKmJXsNCbNl"));
            //{track name=Cut To The Feeling, album name=Cut To The Feeling, artists names=[Ljava.lang.String;@3224a577}
            //expect the following output if you parsed artistsNames:
            //{track name=Cut To The Feeling, album name=Cut To The Feeling, artists names=[Carly Rae Jepsen]}
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
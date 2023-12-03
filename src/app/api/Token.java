package app.api;

import okhttp3.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Base64;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;

public class Token {
    public static void main(String[] args) {
        String clientId = "d3485f3ac16b4af883a20a016b8db2c6";
        String clientSecret = "c59e34fb85fd4c2ca884df41b8cf440d";

        String authString = clientId + ":" + clientSecret;
        String base64AuthString = Base64.getEncoder().encodeToString(authString.getBytes());

        OkHttpClient client = new OkHttpClient();

        RequestBody body = new FormBody.Builder()
                .add("grant_type", "client_credentials")
                .build();

        Request request = new Request.Builder()
                .url("https://accounts.spotify.com/api/token")
                .post(body)
                .addHeader("Authorization", "Basic " + base64AuthString)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                String responseBody = response.body().string();

                // Use Jackson to parse the JSON response and extract access_token
                ObjectMapper mapper = new ObjectMapper();
                Map map = mapper.readValue(responseBody, Map.class);
                String token = (String) map.get("access_token");

                // Save the token to a file
                try (FileWriter writer = new FileWriter("src/app/api/token.txt")) {
                    writer.write(token);
                } catch (IOException e) {
                    System.err.println("Error writing token to file: " + e.getMessage());
                }

            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    //Return token authorization for API call
    public static String get_auth() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src/app/api/token.txt"));
        String token = br.readLine();
        br.close();
        return "Bearer " + token;
    }
}

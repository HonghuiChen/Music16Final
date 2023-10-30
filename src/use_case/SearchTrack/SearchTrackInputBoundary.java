package src.use_case.SearchTrack;

import org.json.JSONException;

import java.io.IOException;

public interface SearchTrackInputBoundary {
    void searchTrack(SearchTrackInputData query) throws IOException, JSONException;
}

package use_case.SearchTrack;

import org.json.JSONException;

import java.io.IOException;

public interface SearchTrackInputBoundary {
    void search(SearchTrackInputData query) throws IOException, JSONException;
}

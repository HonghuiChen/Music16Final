package use_case.SearchTrack;

import java.util.ArrayList;

public class SearchTrackOutputData {
    private final ArrayList results;

    public SearchTrackOutputData(ArrayList results) {
        this.results = results;
    }
    public ArrayList getResults() {
        return results;
    }
}

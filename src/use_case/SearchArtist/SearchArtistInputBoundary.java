package use_case.SearchArtist;

import java.io.IOException;

public interface SearchArtistInputBoundary {
    void searchArtist(SearchArtistInputData searchArtistInputData) throws IOException;
}

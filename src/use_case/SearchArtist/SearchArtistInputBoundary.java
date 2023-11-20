package use_case.SearchArtist;

import java.io.IOException;

public interface SearchArtistInputBoundary {
    void execute(SearchArtistInputData searchArtistInputData) throws IOException;
}

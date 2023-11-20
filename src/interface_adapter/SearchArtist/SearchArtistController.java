package interface_adapter.SearchArtist;

import use_case.SearchArtist.SearchArtistInputBoundary;
import use_case.SearchArtist.SearchArtistInputData;
import use_case.SearchArtist.SearchArtistInteractor;

import java.io.IOException;

public class SearchArtistController {
    final SearchArtistInputBoundary searchArtistInteractor;

    public SearchArtistController(SearchArtistInputBoundary searchArtistInteractor) {
        this.searchArtistInteractor = searchArtistInteractor;
    }

    public void execute(String query) throws IOException {
        SearchArtistInputData searchArtistInputData = new SearchArtistInputData(query);

        searchArtistInteractor.execute(searchArtistInputData);
    }

}

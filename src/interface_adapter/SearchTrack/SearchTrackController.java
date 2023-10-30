package src.interface_adapter.SearchTrack;

import src.use_case.SearchTrack.SearchTrackInputBoundary;
import src.use_case.SearchTrack.SearchTrackInputData;

import java.io.IOException;

public class SearchTrackController {
    final SearchTrackInputBoundary searchTrackUseCaseInteractor;
    public SearchTrackController(SearchTrackInputBoundary searchTrackUseCaseInteractor) {
        this.searchTrackUseCaseInteractor = searchTrackUseCaseInteractor;
    }

    public void execute(String query) throws IOException {
        SearchTrackInputData searchTrackInputData = new SearchTrackInputData(
                query);

        searchTrackUseCaseInteractor.searchTrack(searchTrackInputData);
    }
}

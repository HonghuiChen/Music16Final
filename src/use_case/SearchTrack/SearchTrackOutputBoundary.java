package src.use_case.SearchTrack;

public interface SearchTrackOutputBoundary {
    void prepareSuccessView(SearchTrackOutputData results);
    void prepareFailView(String error);
}

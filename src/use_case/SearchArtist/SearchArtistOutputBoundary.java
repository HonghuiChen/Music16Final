package use_case.SearchArtist;

public interface SearchArtistOutputBoundary {
    void prepareSuccessView(SearchArtistOutputData artistInfo);

    void prepareFailView(String error);

}

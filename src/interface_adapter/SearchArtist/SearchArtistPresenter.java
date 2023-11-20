package interface_adapter.SearchArtist;

import interface_adapter.ViewManagerModel;
import use_case.SearchArtist.SearchArtistInputData;
import use_case.SearchArtist.SearchArtistOutputBoundary;
import use_case.SearchArtist.SearchArtistOutputData;

public class SearchArtistPresenter implements SearchArtistOutputBoundary {

    private final SearchArtistViewModel searchArtistViewModel;

    private ViewManagerModel viewManagerModel;

    public SearchArtistPresenter(ViewManagerModel viewManagerModel, SearchArtistViewModel searchArtistViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.searchArtistViewModel = searchArtistViewModel;
    }


    @Override
    public void prepareSuccessView(SearchArtistOutputData artistInfo) {
//        SearchArtistState searchArtistState = SearchArtistViewModel.getState();
//        searchArtistState.setResult(artistInfo);
//        this.searchArtistViewModel.setState(searchArtistState);
//        searchArtistViewModel.firePropertyChanged();

    }

    @Override
    public void prepareFailView(String error) {
//        SearchArtistState searchArtistState = SearchArtistViewModel.getState();
//        searchArtistState.setArtistNotExistError(error);
//        searchArtistViewModel.firePropertyChanged();
    }


}

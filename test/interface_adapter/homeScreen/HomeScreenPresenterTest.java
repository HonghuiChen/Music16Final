package interface_adapter.homeScreen;

import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenPresenter;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.SearchTrack.SearchTrackOutputData;

import java.util.ArrayList;

import static org.mockito.Mockito.*;

class HomeScreenPresenterTest {

    @Mock
    private ViewManagerModel mockViewManagerModel;
    @Mock
    private HomeScreenViewModel mockHomeScreenViewModel;
    @Mock
    private LoginViewModel mockLoginViewModel;

    private HomeScreenPresenter homeScreenPresenter;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        homeScreenPresenter = new HomeScreenPresenter(mockViewManagerModel, mockHomeScreenViewModel, mockLoginViewModel);
        when(mockHomeScreenViewModel.getState()).thenReturn(new HomeScreenState());
    }

    @Test
    void testPrepareSuccessView() {
        SearchTrackOutputData mockData = new SearchTrackOutputData(new ArrayList<>());
        homeScreenPresenter.prepareSuccessView(mockData);

        verify(mockHomeScreenViewModel).setState(any(HomeScreenState.class));
        verify(mockHomeScreenViewModel).firePropertyChanged("searchTracks");
        verify(mockViewManagerModel).setActiveView(mockHomeScreenViewModel.getViewName());
        verify(mockViewManagerModel).firePropertyChanged();
    }

    @Test
    void testPrepareFailView() {
        String error = "Error message";
        homeScreenPresenter.prepareFailView(error);

        verify(mockHomeScreenViewModel).setState(any(HomeScreenState.class));
        verify(mockHomeScreenViewModel).firePropertyChanged("SearchTrackError");
        verify(mockViewManagerModel).setActiveView(mockHomeScreenViewModel.getViewName());
        verify(mockViewManagerModel).firePropertyChanged();
    }
}

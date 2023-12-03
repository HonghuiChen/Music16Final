package interface_adapter.GenrePreference;

import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenState;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.GenrePreference.GenreState;
import interface_adapter.GenrePreference.GenreViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.addGenrePreference.addGenrePreferenceOutputBoundary;
import use_case.addGenrePreference.addGenrePreferenceOutputData;
import use_case.deleteGenrePreference.deleteGenrePreferenceOutputBoundary;
import use_case.deleteGenrePreference.deleteGenrePreferenceOutputData;

import java.util.Objects;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class GenrePresenterTest {
    @Mock
    private GenreViewModel mockGenreModel;
    @Mock
    private HomeScreenViewModel mockHomeScreenModel;
    @Mock
    private ViewManagerModel mockViewManagerModel;

    private addGenrePreferenceOutputBoundary addGenrePresenter;
    private deleteGenrePreferenceOutputBoundary deleteGenrePresenter;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        addGenrePresenter = new GenrePresenter(mockViewManagerModel, mockGenreModel);
        deleteGenrePresenter = new GenrePresenter(mockViewManagerModel, mockGenreModel);
    }

    @Test
    void testAddSuccess() {
        addGenrePreferenceOutputData response = new addGenrePreferenceOutputData("genre", false);
        GenreState genreState = new GenreState();
        when(mockGenreModel.getState()).thenReturn(genreState);
        addGenrePresenter.prepareAddSuccessView(response);
        verify(mockGenreModel).firePropertyChanged();
    }

    @Test
    void testAddFail() {
        String error = "Error message";
        GenreState genreState = new GenreState();
        when(mockGenreModel.getState()).thenReturn(genreState);
        addGenrePresenter.prepareAddFailView(error);

        verify(mockGenreModel).getState();
        verify(mockGenreModel).firePropertyChanged();
    }

    @Test
    void testDeleteSuccess() {
        deleteGenrePreferenceOutputData response = new deleteGenrePreferenceOutputData("genre", false);
        GenreState genreState = new GenreState();
        when(mockGenreModel.getState()).thenReturn(genreState);
        deleteGenrePresenter.prepareDeleteSuccessView(response);
        verify(mockGenreModel).firePropertyChanged();
    }

    @Test
    void testDeleteFail() {
        String error = "Error message";
        GenreState genreState = new GenreState();
        when(mockGenreModel.getState()).thenReturn(genreState);
        deleteGenrePresenter.prepareDeleteFailView(error);

        verify(mockGenreModel).getState();
        verify(mockGenreModel).firePropertyChanged();
    }

    @Test
    void testSwitchView() {
        String viewName = "genre preference";
        when(mockGenreModel.getViewName()).thenReturn(viewName);
        GenrePresenter genrePresenterMock = mock(GenrePresenter.class);
        genrePresenterMock.switchView();
        verify(this.mockViewManagerModel).setActiveView(mockGenreModel.getViewName());
        verify(this.mockViewManagerModel).firePropertyChanged();
    }

    @Test
    void testCancel() {
        GenrePresenter genrePresenterMock = mock(GenrePresenter.class);
        genrePresenterMock.cancel();
        verify(this.mockViewManagerModel).setActiveView("Home Screen");
        verify(this.mockViewManagerModel).firePropertyChanged();

    }
}

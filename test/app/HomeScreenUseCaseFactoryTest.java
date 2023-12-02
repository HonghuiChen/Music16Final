package app;

import interface_adapter.GenrePreference.GenreViewModel;
import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.login.LoginViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.addGenrePreference.addGenrePreferenceDataAccessInterface;
import use_case.deleteGenrePreference.deleteGenrePreferenceDataAccessInterface;
import view.HomeScreenView;
import use_case.logout.LogoutInteractor;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class HomeScreenUseCaseFactoryTest {

    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private LoginViewModel loginViewModel;
    @Mock
    private HomeScreenViewModel homeScreenViewModel;
    @Mock
    private GenreViewModel genreViewModel;
    @Mock
    private addGenrePreferenceDataAccessInterface addGenreDataAccessObject;
    @Mock
    private deleteGenrePreferenceDataAccessInterface deleteGenreDataAccessObject;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        // Call the create method
        HomeScreenView homeScreenView = HomeScreenUseCaseFactory.create(viewManagerModel, loginViewModel,
                homeScreenViewModel, genreViewModel, addGenreDataAccessObject, deleteGenreDataAccessObject);

        // Assert that a HomeScreenView is returned
        assertNotNull(homeScreenView, "HomeScreenView should not be null");

        // Optionally, verify interactions with mocks
        // Example: verify(addGenreDataAccessObject, times(1)).someMethod();
    }
}

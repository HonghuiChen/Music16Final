package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenViewModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginPresenterTest {

    @Test
    void prepareFailViewTest() {

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        HomeScreenViewModel homeScreenViewModel = new HomeScreenViewModel();
        LoginViewModel loginViewModel = new LoginViewModel();
        LoginPresenter presenter = new LoginPresenter(viewManagerModel, homeScreenViewModel, loginViewModel);

        presenter.prepareFailView("some error");
        assertEquals(loginViewModel.getState().getUsernameError(), "some error");
    }
}
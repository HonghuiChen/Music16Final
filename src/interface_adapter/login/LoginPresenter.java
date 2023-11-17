package interface_adapter.login;

import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenState;
import interface_adapter.homeScreen.HomeScreenViewModel;
import use_case.login.LoginOutputBoundary;
import use_case.login.LoginOutputData;

public class LoginPresenter implements LoginOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final HomeScreenViewModel homeScreenViewModel;
    private ViewManagerModel viewManagerModel;
    private HomeScreenState homeScreenState;

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          HomeScreenViewModel homeScreenViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeScreenViewModel = homeScreenViewModel;
        this.loginViewModel = loginViewModel;
    }

    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to the logged in view.

        HomeScreenState homeScreenState = homeScreenViewModel.getState();
        homeScreenState.setUsername(response.getUsername());
        this.homeScreenViewModel.setState(homeScreenState);
        this.homeScreenViewModel.firePropertyChanged();

        this.viewManagerModel.setActiveView(homeScreenViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }

    @Override
    public void prepareFailView(String error) {
        LoginState loginState = loginViewModel.getState();
        loginState.setUsernameError(error);
        loginViewModel.firePropertyChanged();
    }
}

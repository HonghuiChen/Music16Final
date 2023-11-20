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

    public LoginPresenter(ViewManagerModel viewManagerModel,
                          HomeScreenViewModel homeScreenViewModel,
                          LoginViewModel loginViewModel) {
        this.viewManagerModel = viewManagerModel;
        this.homeScreenViewModel = homeScreenViewModel;
        this.loginViewModel = loginViewModel;
    }

    //TODO DEBUG THIS, NOT SWITCHING TO HOME SCREEN
    @Override
    public void prepareSuccessView(LoginOutputData response) {
        // On success, switch to Home Screen view.
        System.out.println("Switching to Home Screen view");
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

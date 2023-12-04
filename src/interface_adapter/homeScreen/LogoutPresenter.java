package interface_adapter.homeScreen;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.logout.LogoutOutputBoundary;

import javax.swing.*;

public class LogoutPresenter implements LogoutOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final HomeScreenViewModel homeScreenViewModel;
    private ViewManagerModel viewManagerModel;

    public LogoutPresenter(LoginViewModel loginViewModel, HomeScreenViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.homeScreenViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        LoginState loginState = loginViewModel.getState();
        loginState.setPassword("");
        this.loginViewModel.setState(loginState);
        this.loginViewModel.firePropertyChanged();
        HomeScreenState homeScreenState = homeScreenViewModel.getState();
        homeScreenState.setUsername("");
        this.homeScreenViewModel.setState(homeScreenState);
        this.homeScreenViewModel.firePropertyChanged();
        //switch to log in view
        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}

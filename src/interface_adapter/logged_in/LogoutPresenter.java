package interface_adapter.logged_in;

import interface_adapter.ViewManagerModel;
import interface_adapter.login.LoginState;
import interface_adapter.login.LoginViewModel;
import use_case.logout.LogoutOutputBoundary;

public class LogoutPresenter implements LogoutOutputBoundary {

    private final LoginViewModel loginViewModel;
    private final LoggedInViewModel loggedInViewModel;
    private ViewManagerModel viewManagerModel;

    public LogoutPresenter(LoginViewModel loginViewModel, LoggedInViewModel loggedInViewModel, ViewManagerModel viewManagerModel) {
        this.loginViewModel = loginViewModel;
        this.loggedInViewModel = loggedInViewModel;
        this.viewManagerModel = viewManagerModel;
    }

    @Override
    public void prepareSuccessView() {
        LoginState loginState = loginViewModel.getState();
        loginState.setPassword("");
        this.loginViewModel.setState(loginState);
        this.loginViewModel.firePropertyChanged();
        LoggedInState loggedInState = loggedInViewModel.getState();
        loggedInState.setUsername("");
        this.loggedInViewModel.setState(loggedInState);
        this.loggedInViewModel.firePropertyChanged();
        //switch to log in view
        this.viewManagerModel.setActiveView(loginViewModel.getViewName());
        this.viewManagerModel.firePropertyChanged();
    }
}

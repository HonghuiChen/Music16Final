package app;

import interface_adapter.ViewManagerModel;
import interface_adapter.logged_in.LoggedInViewModel;
import interface_adapter.logged_in.LogoutController;
import interface_adapter.logged_in.LogoutPresenter;
import interface_adapter.login.LoginViewModel;
import use_case.logout.LogoutInputBoundary;
import use_case.logout.LogoutInteractor;
import use_case.logout.LogoutOutputBoundary;
import view.LoggedInView;

public class LogoutUseCaseFactory {

    private LogoutUseCaseFactory() {}

    public static LoggedInView create(ViewManagerModel viewManagerModel,LoginViewModel loginViewModel,LoggedInViewModel loggedInViewModel) {
        LogoutController loginController = createLogoutUseCase(viewManagerModel, loginViewModel, loggedInViewModel);
        return new LoggedInView(loggedInViewModel, loginController);
    }

    private static LogoutController createLogoutUseCase(
            ViewManagerModel viewManagerModel,
            LoginViewModel loginViewModel,
            LoggedInViewModel loggedInViewModel) {

        // Notice how we pass this method's parameters to the Presenter.
        LogoutOutputBoundary logoutOutputBoundary = new LogoutPresenter(loginViewModel, loggedInViewModel, viewManagerModel);

        LogoutInputBoundary logoutInteractor = new LogoutInteractor(
                logoutOutputBoundary);

        return new LogoutController(logoutInteractor);
    }
}

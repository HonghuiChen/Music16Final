package interface_adapter.login;

import use_case.login.LoginInputBoundary;
import use_case.login.LoginInputData;

public class LoginController {

    final LoginInputBoundary loginUseCaseInteractor;
    public LoginController(LoginInputBoundary loginUseCaseInteractor) {
        this.loginUseCaseInteractor = loginUseCaseInteractor;
    }

    public void cancel() {
        loginUseCaseInteractor.switchView();
    }
    public void execute(String username, String password) {
        LoginInputData loginInputData = new LoginInputData(
                username, password);
        loginUseCaseInteractor.storeCurrUser(username);
        loginUseCaseInteractor.execute(loginInputData);
    }
}

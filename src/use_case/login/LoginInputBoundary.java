package use_case.login;

public interface LoginInputBoundary {
    void execute(LoginInputData loginInputData);

    void switchView();

    void storeCurrUser(String username);
}

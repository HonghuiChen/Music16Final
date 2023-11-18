package interface_adapter.logged_in;

import use_case.logout.LogoutInputBoundary;

public class LogoutController {

    final LogoutInputBoundary logoutInteractor;

    public LogoutController(LogoutInputBoundary logoutInteractor) {
        this.logoutInteractor = logoutInteractor;
    }

    public void execute() {
        logoutInteractor.execute();
    }
}

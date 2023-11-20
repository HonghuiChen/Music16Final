package use_case.logout;

public class LogoutInteractor implements LogoutInputBoundary{

    final LogoutOutputBoundary logoutPresenter;

    public LogoutInteractor(LogoutOutputBoundary logoutOutputboundary) {
        this.logoutPresenter = logoutOutputboundary;
    }

    @Override
    public void execute() {
        logoutPresenter.prepareSuccessView();
    }
}

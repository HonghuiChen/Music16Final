package app;

import data_access.FileUserDataAccessObject;
import entity.UserFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.signup.SignupViewModel;
import view.HomeScreenView;
import view.LoginView;
import view.SignupView;
import view.ViewManager;
import app.api.Token;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        // Build the main program window, the main panel containing the
        // various cards, and the layout, and stitch them together.

        // Create Token
        Token.main(new String[]{""});
        // The main application window.
        JFrame application = new JFrame("Login Example");
        application.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CardLayout cardLayout = new CardLayout();

        // The various View objects. Only one view is visible at a time.
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        // This keeps track of and manages which view is currently showing.
        ViewManagerModel viewManagerModel = new ViewManagerModel();
        new ViewManager(views, cardLayout, viewManagerModel);

        // The data for the views, such as username and password, are in the ViewModels.
        // This information will be changed by a presenter object that is reporting the
        // results from the use case. The ViewModels are observable, and will
        // be observed by the Views.
        LoginViewModel loginViewModel = new LoginViewModel();
        HomeScreenViewModel homeScreenViewModel = new HomeScreenViewModel();
        SignupViewModel signupViewModel = new SignupViewModel();

        FileUserDataAccessObject userDataAccessObject;
        try {
            userDataAccessObject = new FileUserDataAccessObject("./users.csv", new UserFactory());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        SignupView signupView = SignupUseCaseFactory.create(viewManagerModel, loginViewModel, signupViewModel, userDataAccessObject);
        views.add(signupView, signupView.viewName);

        LoginView loginView = LoginUseCaseFactory.create(viewManagerModel, loginViewModel, homeScreenViewModel, userDataAccessObject);
        views.add(loginView, loginView.viewName);

        HomeScreenView homeScreenView = HomeScreenUseCaseFactory.create(viewManagerModel, loginViewModel, homeScreenViewModel);
        views.add(homeScreenView, homeScreenView.viewName);
//=======
//        HomeScreenView loggedInView = LogoutUseCaseFactory.create(viewManagerModel, loginViewModel, homeScreenViewModel);
//        views.add(loggedInView, loggedInView.viewName);
//>>>>>>> main

        //TODO Need to change back to loginView.viewName
        viewManagerModel.setActiveView(homeScreenView.viewName);
        viewManagerModel.firePropertyChanged();

        application.pack();
        application.setVisible(true);
    }
}
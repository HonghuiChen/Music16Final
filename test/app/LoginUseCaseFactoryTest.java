import app.LoginUseCaseFactory;
import interface_adapter.ViewManagerModel;
import interface_adapter.homeScreen.HomeScreenViewModel;
import interface_adapter.login.LoginViewModel;
import interface_adapter.login.LoginController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import use_case.login.LoginUserDataAccessInterface;
import view.LoginView;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static app.LoginUseCaseFactory.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class LoginUseCaseFactoryTest {

    @Mock
    private ViewManagerModel viewManagerModel;
    @Mock
    private LoginViewModel loginViewModel;
    @Mock
    private HomeScreenViewModel homeScreenViewModel;
    @Mock
    private LoginUserDataAccessInterface userDataAccessObject;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateLoginView() {
        LoginView loginView = create(viewManagerModel, loginViewModel, homeScreenViewModel, userDataAccessObject);
        assertNotNull(loginView, "LoginView should not be null");
    }

    @Test
    void testCreateLoginController() {
        LoginController loginController = invokeCreateLoginUseCase();
        assertNotNull(loginController, "LoginController should not be null");
    }

    private LoginController invokeCreateLoginUseCase() {
    try {
        // Get the Class object
        Class<?> factoryClass = Class.forName("app.LoginUseCaseFactory");

        // Get the Method object for the private method
        Method createLoginUseCaseMethod = factoryClass.getDeclaredMethod("createLoginUseCase",
                ViewManagerModel.class, LoginViewModel.class, HomeScreenViewModel.class, LoginUserDataAccessInterface.class);

        // Make the method accessible
        createLoginUseCaseMethod.setAccessible(true);
        return (LoginController) createLoginUseCaseMethod.invoke(
                null, viewManagerModel, loginViewModel, homeScreenViewModel, userDataAccessObject);
    } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        throw new RuntimeException(e);
    }
    }
    @Test
    void testCreateLoginUseCaseUsingReflection() {
        try {
            // Get the Class object
            Class<?> factoryClass = Class.forName("app.LoginUseCaseFactory");

            // Get the Method object for the private method
            Method createLoginUseCaseMethod = factoryClass.getDeclaredMethod("createLoginUseCase",
                    ViewManagerModel.class, LoginViewModel.class, HomeScreenViewModel.class, LoginUserDataAccessInterface.class);

            // Make the method accessible
            createLoginUseCaseMethod.setAccessible(true);

            // Invoke the method and get the result
            LoginController loginController = (LoginController) createLoginUseCaseMethod.invoke(
                    null, viewManagerModel, loginViewModel, homeScreenViewModel, userDataAccessObject);

            // Asserts and checks
            assertNotNull(loginController, "LoginController should not be null");

        } catch (Exception e) {
            e.printStackTrace();
            fail("Reflection to access private method failed");
        }
    }
}

package use_case.login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginInputDataTest {

    LoginInputData loginInputData = new LoginInputData("username", "password");
    @Test
    void getUsername() {
        assertEquals("username", loginInputData.getUsername());
    }

    @Test
    void getPassword() {
        assertEquals("password", loginInputData.getPassword());
    }
}
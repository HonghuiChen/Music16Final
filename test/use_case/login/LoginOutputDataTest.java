package use_case.login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginOutputDataTest {

    LoginOutputData loginOutputData = new LoginOutputData("username", false);
    @Test
    void getUsername() {
        assertEquals("username", loginOutputData.getUsername());
    }

    @Test
    void isUseCaseFailed() {
        assertFalse(loginOutputData.isUseCaseFailed());
    }
}
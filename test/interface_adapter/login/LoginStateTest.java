package interface_adapter.login;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoginStateTest {

    @Test
    void constructorTest() {
        LoginState state1 = new LoginState();
        LoginState state2 = new LoginState(state1);
        assertEquals(state1.getUsername(), state2.getUsername());
    }

    @Test
    void getUsernameErrorTest() {
        LoginState state1 = new LoginState();
        state1.setUsernameError("some error");
        assertEquals(state1.getUsernameError(), "some error");
    }
    @Test
    void getPasswordErrorTest() {
        LoginState state1 = new LoginState();
        state1.setPasswordError("some error");
        assertEquals(state1.getPasswordError(), "some error");
    }



}
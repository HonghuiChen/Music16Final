package interface_adapter.signup;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SignupStateTest {

    @Test
    void testDefaultConstructor() {
        SignupState state = new SignupState();
        assertNull(state.getUsernameError());
        assertNull(state.getPasswordError());
        assertNull(state.getRepeatPasswordError());
        assertEquals("", state.getUsername());
        assertEquals("", state.getPassword());
        assertEquals("", state.getRepeatPassword());
    }

    @Test
    void testCopyConstructor() {
        SignupState original = new SignupState();
        original.setUsername("user");
        original.setPassword("pass");
        original.setRepeatPassword("pass2");
        original.setUsernameError("username error");
        original.setPasswordError("password error");
        original.setRepeatPasswordError("repeat password error");

        SignupState copy = new SignupState(original);
        assertEquals("user", copy.getUsername());
        assertEquals("pass", copy.getPassword());
        assertEquals("pass2", copy.getRepeatPassword());
        assertEquals("username error", copy.getUsernameError());
        assertEquals("password error", copy.getPasswordError());
        assertEquals("repeat password error", copy.getRepeatPasswordError());
    }

    @Test
    void testSettersAndGetters() {
        SignupState state = new SignupState();
        state.setUsername("user");
        state.setPassword("pass");
        state.setRepeatPassword("pass2");
        state.setUsernameError("username error");
        state.setPasswordError("password error");
        state.setRepeatPasswordError("repeat password error");

        assertEquals("user", state.getUsername());
        assertEquals("pass", state.getPassword());
        assertEquals("pass2", state.getRepeatPassword());
        assertEquals("username error", state.getUsernameError());
        assertEquals("password error", state.getPasswordError());
        assertEquals("repeat password error", state.getRepeatPasswordError());
        System.out.println(state);
    }
}

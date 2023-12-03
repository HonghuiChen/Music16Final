package interface_adapter.homeScreen;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class HomeScreenStateTest {

    @Test
    void testDefaultConstructor() {
        HomeScreenState state = new HomeScreenState();
        assertEquals("", state.getUsername());
        state.setOutput(new ArrayList<>());
        assertEquals("",state.getOutput());
    }

    @Test
    void testCopyConstructor() {
        HomeScreenState original = new HomeScreenState();
        original.setUsername("user");
        ArrayList<String> output = new ArrayList<>();
        output.add("output1");
        output.add("output2");
        original.setOutput(output);

        HomeScreenState copy = new HomeScreenState(original);
        assertEquals("user", copy.getUsername());
        assertEquals("output1\noutput2\n", copy.getOutput());
    }

    @Test
    void testSettersAndGetters() {
        HomeScreenState state = new HomeScreenState();
        state.setUsername("user");
        ArrayList<String> output = new ArrayList<>();
        output.add("output1");
        state.setOutput(output);
        state.setError("error");

        assertEquals("user", state.getUsername());
        assertEquals("output1\n", state.getOutput());
    }
}

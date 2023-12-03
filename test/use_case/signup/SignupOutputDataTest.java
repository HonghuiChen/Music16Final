package use_case.signup;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class SignupOutputDataTest {

    @Test
    void testMethods() throws InterruptedException {
        String creationTime = LocalDateTime.now().toString();
        SignupOutputData user = new SignupOutputData("son", creationTime, false);
        //Assert getUserName()
        assertEquals("son", user.getUsername(), "username should match the one provided");
        assertEquals(creationTime, user.getCreationTime(), "Creation time should match");
        TimeUnit.SECONDS.sleep(1);
        String newTime = LocalDateTime.now().toString();
        user.setCreationTime(newTime);
        assertEquals(newTime, user.getCreationTime(), "Creation time should match");

    }
}
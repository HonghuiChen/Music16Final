package entity;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserInitialization() {
        LocalDateTime creationTime = LocalDateTime.now();
        User user = new User("testUser", "password123", creationTime);

        assertNotNull(user, "User object should not be null");
        assertEquals("testUser", user.getUsername(), "Username should match the one provided");
        assertEquals("password123", user.getPassword(), "Password should match the one provided");
        assertEquals(creationTime, user.getCreationTime(), "Creation time should match the one provided");
    }

    @Test
    void testGetUsername() {
        User user = new User("username", "password", LocalDateTime.now());
        assertEquals("username", user.getUsername(), "getUsername should return the correct username");
    }

    @Test
    void testGetPassword() {
        User user = new User("username", "password", LocalDateTime.now());
        assertEquals("password", user.getPassword(), "getPassword should return the correct password");
    }

    @Test
    void testGetCreationTime() {
        LocalDateTime now = LocalDateTime.now();
        User user = new User("username", "password", now);
        assertEquals(now, user.getCreationTime(), "getCreationTime should return the correct creation time");
    }
}
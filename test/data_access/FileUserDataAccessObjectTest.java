package data_access;

import entity.User;
import entity.UserFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class FileUserDataAccessObjectTest {

    @Mock
    private UserFactory userFactory;

    @Mock
    private User user;

    private FileUserDataAccessObject fileUserDataAccessObject;

    @BeforeEach
    void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        fileUserDataAccessObject = new FileUserDataAccessObject("test_users.csv", userFactory);

        // Mock User setup
        when(userFactory.create(anyString(), anyString(), any(LocalDateTime.class))).thenReturn(user);
        when(user.getUsername()).thenReturn("testUser");
        when(user.getPassword()).thenReturn("testPassword");
        when(user.getCreationTime()).thenReturn(LocalDateTime.now());
        when(user.getFavoriteSongs()).thenReturn(new ArrayList<>());
        when(user.getFavoriteArist()).thenReturn(new ArrayList<>());
        when(user.getGenrePreference()).thenReturn(new ArrayList<>());
        // Add more mock setups as needed
    }

    @Test
    void testSaveAndRetrieveUser() {
        fileUserDataAccessObject.save(user);
        User retrievedUser = fileUserDataAccessObject.get("testUser");
        assertNotNull(retrievedUser);
        assertEquals("testUser", retrievedUser.getUsername());
    }

    @Test
    void testUserExistsByName() {
        boolean exists = fileUserDataAccessObject.existsByName("testUser");
        assertTrue(exists);
    }

    @Test
    void testStoreAndReadCurrUser() throws IOException {
        fileUserDataAccessObject.storeCurrUser("testUser");
        String currUser = fileUserDataAccessObject.readCurrUser("currentUser.txt");
        assertEquals("testUser", currUser);
    }

//    @Test
//    void testIOExceptionHandling() {
//        // Verify RuntimeException is thrown
//        assertThrows(RuntimeException.class, () -> fileUserDataAccessObject.save(user));
//    }

    // Additional tests can be added for private methods or specific scenarios
}

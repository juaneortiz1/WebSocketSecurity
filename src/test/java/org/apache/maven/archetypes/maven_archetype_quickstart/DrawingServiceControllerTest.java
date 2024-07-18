package org.apache.maven.archetypes.maven_archetype_quickstart;

import org.apache.maven.archetypes.maven_archetype_quickstart.controller.DrawingServiceController;
import org.apache.maven.archetypes.maven_archetype_quickstart.model.User;
import org.apache.maven.archetypes.maven_archetype_quickstart.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DrawingServiceControllerTest {

    @Mock
    private UserService userServiceMock;

    @InjectMocks
    private DrawingServiceController controller;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadUserByUsername_existingUser() {

        String username = "existingUser";
        User mockUser = new User(username, "password");
        when(userServiceMock.findByName(username)).thenReturn(mockUser);

        UserDetails userDetails = controller.loadUserByUsername(username);


        assertNotNull(userDetails);
        assertEquals(username, userDetails.getUsername());
        assertTrue(userDetails.getAuthorities().stream()
                .anyMatch(auth -> auth.getAuthority().equals("ROLE_USER")));
    }

    @Test
    public void testLoadUserByUsername_nonExistingUser() {

        String username = "nonExistingUser";
        when(userServiceMock.findByName(username)).thenReturn(null);

        assertThrows(UsernameNotFoundException.class,
                () -> controller.loadUserByUsername(username));
    }
}


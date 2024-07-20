package org.apache.maven.archetypes.maven_archetype_quickstart;

import org.apache.maven.archetypes.maven_archetype_quickstart.model.MainUser;
import org.apache.maven.archetypes.maven_archetype_quickstart.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MainUserTest {

    @Mock
    private User mockUser;

    @InjectMocks
    private MainUser mainUser;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetPassword() {

        String expectedPassword = "password123";
        when(mockUser.getPass()).thenReturn(expectedPassword);


        String actualPassword = mainUser.getPassword();


        assertEquals(expectedPassword, actualPassword, "Password should match the expected value");
    }
}

package org.apache.maven.archetypes.maven_archetype_quickstart;

import org.apache.maven.archetypes.maven_archetype_quickstart.model.User;
import org.apache.maven.archetypes.maven_archetype_quickstart.repository.UserRepository;
import org.apache.maven.archetypes.maven_archetype_quickstart.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveUser() {
        User user = new User("testuser", "password");
        when(userRepository.save(user)).thenReturn(user);
        User savedUser = userService.save(user);
        assertEquals(user, savedUser);
        verify(userRepository, times(1)).save(user);
    }

    @Test
    public void testFindAllUsers() {
        User user1 = new User("user1", "pass1");
        User user2 = new User("user2", "pass2");
        List<User> userList = Arrays.asList(user1, user2);
        when(userRepository.findAll()).thenReturn(userList);
        List<User> foundUsers = userService.findAll();
        assertEquals(2, foundUsers.size());
        assertEquals(userList, foundUsers);
        verify(userRepository, times(1)).findAll();
    }

    @Test
    public void testFindByName() {
        User user = new User("testuser", "password");
        when(userRepository.findByName("testuser")).thenReturn(user);
        User foundUser = userService.findByName("testuser");
        assertEquals(user, foundUser);
        verify(userRepository, times(1)).findByName("testuser");
    }
}
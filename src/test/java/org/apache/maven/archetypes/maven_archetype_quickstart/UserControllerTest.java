package org.apache.maven.archetypes.maven_archetype_quickstart;

import org.apache.maven.archetypes.maven_archetype_quickstart.controller.UserController;
import org.apache.maven.archetypes.maven_archetype_quickstart.model.User;
import org.apache.maven.archetypes.maven_archetype_quickstart.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Captor
    private ArgumentCaptor<User> userCaptor;

    @Test
    public void testCreates() {

        String username = "testUser";
        String password = "testPassword";
        Model model = mock(Model.class);

        String result = userController.creates(username, password, model);
        assertEquals("home", result);

        verify(userService, times(1)).save(userCaptor.capture());
        User capturedUser = userCaptor.getValue();
        assertEquals(username, capturedUser.getName());
    }
@Test
    public void testGetAllUsers() {
        // Given
        User user1 = new User("user1", "password1");
        User user2 = new User("user2", "password2");
        List<User> userList = Arrays.asList(user1, user2);

        when(userService.findAll()).thenReturn(userList);

        List<User> result = userController.getAllUsers();


        assertEquals(2, result.size());
        assertEquals(user1.getName(), result.get(0).getName());
        assertEquals(user2.getName(), result.get(1).getName());
    }
}


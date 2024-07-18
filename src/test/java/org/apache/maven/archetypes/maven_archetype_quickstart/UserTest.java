package org.apache.maven.archetypes.maven_archetype_quickstart;


import org.apache.maven.archetypes.maven_archetype_quickstart.model.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {

    @Test
    public void testUserConstructor() {
        User user = new User("testUser", "testPass");
        assertEquals("testUser", user.getName());
        assertEquals("testPass", user.getPass());
    }

    @Test
    public void testSetName() {
        User user = new User();
        user.setName("testUser");
        assertEquals("testUser", user.getName());
    }

    @Test
    public void testSetPass() {
        User user = new User();
        user.setPass("testPass");
        assertEquals("testPass", user.getPass());
    }

    @Test
    public void testToString() {
        User user = new User("testUser", "testPass");
        String expectedToString = "User [name=testUser, pass=testPass]";
        assertEquals(expectedToString, user.toString());
    }
}

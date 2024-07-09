package org.apache.maven.archetypes.maven_archetype_quickstart.controller;

import org.apache.maven.archetypes.maven_archetype_quickstart.model.User;
import org.apache.maven.archetypes.maven_archetype_quickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/creates")
    public String creates(String usern, String password, Model model) {
        System.out.println("Received request to create user with username: " + usern);
        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(usern, encodedPassword);
        userService.save(user);
        System.out.println("Registry Succeed with " + usern + " current password " + encodedPassword);
        return "home"; // Asegúrate de que exista una vista llamada "home"
    }


    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}

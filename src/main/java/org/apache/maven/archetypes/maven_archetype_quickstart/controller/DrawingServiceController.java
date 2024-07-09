package org.apache.maven.archetypes.maven_archetype_quickstart.controller;

import org.apache.maven.archetypes.maven_archetype_quickstart.model.MainUser;
import org.apache.maven.archetypes.maven_archetype_quickstart.model.User;
import org.apache.maven.archetypes.maven_archetype_quickstart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class DrawingServiceController implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User user = userService.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return new MainUser(user, new HashSet<>(authorities));
    }
}

package org.apache.maven.archetypes.maven_archetype_quickstart.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Set;

public class MainUser implements UserDetails {
    private User user;
    private final Set<GrantedAuthority> authorities;

    @SuppressWarnings("unchecked")
    public MainUser(User user, Collection<? extends GrantedAuthority> authorities) {
        this.user= user;
        this.authorities= (Set<GrantedAuthority>) authorities;
    }

    @Override
    public Collection<GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return user.getName();
    }
}

package com.pelican.api.auth.security;

import com.pelican.api.models.User;
import com.pelican.api.models.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public final class ApplicationUserDetailsFactory {

    public static ApplicationUserDetails create(User user){
        return new ApplicationUserDetails(
                user.getUsername(),
                user.getPassword(),
                mapToGrantedAutorities(user.getRoles()),
                true,
                true,
                true,
                true);
    }

    private static List<? extends GrantedAuthority> mapToGrantedAutorities(Set<UserRole> roles){
        List<? extends GrantedAuthority> authorities = roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
        return authorities;
    }

}

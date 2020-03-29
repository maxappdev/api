package com.pelican.api.auth.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class ApplicationUserDetailsService implements UserDetailsService {

    private final ApplicationUserDetailsDao userDetailsDao;

    @Autowired
    public ApplicationUserDetailsService(ApplicationUserDetailsDao userDetailsDao) {
        this.userDetailsDao = userDetailsDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userDetailsDao.selectUserDetailsByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }
}

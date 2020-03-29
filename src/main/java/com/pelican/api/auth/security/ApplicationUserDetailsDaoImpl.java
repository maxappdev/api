package com.pelican.api.auth.security;

import com.pelican.api.models.User;
import com.pelican.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApplicationUserDetailsDaoImpl implements ApplicationUserDetailsDao {

    private final UserRepository userRepository;

    @Autowired
    public ApplicationUserDetailsDaoImpl(UserRepository userRepository,
                                         ApplicationUserDetailsFactory userDetailsFactory) {
        this.userRepository = userRepository;
    }


    @Override
    public Optional<ApplicationUserDetails> selectUserDetailsByUsername(String username) {
        User user = userRepository.findByUsername(username);

        return Optional.of(ApplicationUserDetailsFactory.create(user));

    }
}

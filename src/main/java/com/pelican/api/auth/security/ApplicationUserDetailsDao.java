package com.pelican.api.auth.security;

import java.util.Optional;

public interface ApplicationUserDetailsDao {
    Optional<ApplicationUserDetails> selectUserDetailsByUsername(String usename);
}

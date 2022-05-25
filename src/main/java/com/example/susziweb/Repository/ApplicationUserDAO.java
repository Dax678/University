package com.example.susziweb.Repository;

import com.example.susziweb.auth.ApplicationUserDetails;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ApplicationUserDAO {
    Optional<ApplicationUserDetails> selectUserByUsername(String username);
}

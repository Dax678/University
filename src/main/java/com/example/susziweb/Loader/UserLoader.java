package com.example.susziweb.Loader;

import com.example.susziweb.Repository.UserRepository;
import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.Entity.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserLoader implements CommandLineRunner {
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
    }
}

package com.example.susziweb.auth;

import com.example.susziweb.Repository.ApplicationUserDAO;
import com.example.susziweb.Repository.UserRepository;
import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.Entity.User;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDAO {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final UserService userService;

    @Autowired
    public FakeApplicationUserDaoService(PasswordEncoder passwordEncoder, UserRepository userRepository, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @Override
    public Optional<ApplicationUserDetails> selectUserByUsername(String username) {
        return getUsers().stream()
                .filter(applicationUserDetails -> username.equals(applicationUserDetails.getUsername()))
                .findFirst();
    }

    private List<ApplicationUserDetails> getUsers() {
        List<ApplicationUserDetails> userList = Lists.newArrayList();
                for(User user : userService.findAllUsers())
                    userList.add(
                            new ApplicationUserDetails(ApplicationUserRole.valueOf(userService.findUserRole(user)).getGrantedAuthorities(),
                                    passwordEncoder.encode(user.getPassword()),
                                    user.getLogin(),
                                    true,
                                    true,
                                    true,
                                    true));
        return userList;
    }
}

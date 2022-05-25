package com.example.susziweb.Service;

import com.example.susziweb.Repository.UserRepository;
import com.example.susziweb.db.Entity.Message;
import com.example.susziweb.db.LoggedUser;
import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.Entity.User_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private LoggedUser loggedUser;

    @Autowired
    public UserService(UserRepository userRepository, LoggedUser loggedUser) {
        this.userRepository = userRepository;
        this.loggedUser = loggedUser;
    }

    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    public User_details findUserDetailsByUsername(String username) {
        return userRepository.findUserDetailsByUsername(findUserByUsername(username));
    }

    public User findUserByUsername(String login) {
        return userRepository.findUserByLogin(login);
    }

    public List<Object[]> findAllUsersWithRole() {
        return userRepository.findAllUsersWithRole();
    }

    public String findUserRole(User user) {
        return userRepository.findUserRole(user);
    }

    public List<Object[]> findUserSectionInfo(User user) {
        return userRepository.findUserSectionInfo(user);
    }

    public List<Message> findAddressedToUserMessages(User user) {
        List<Message> mess = userRepository.findAddressedToUserMessages(user);
        return mess;
    }
}

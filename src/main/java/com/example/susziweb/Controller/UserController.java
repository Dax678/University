package com.example.susziweb.Controller;

import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.LoggedUser;
import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.Entity.User_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sushi-web/api")
public class UserController {
    private final UserService userService;
    private final LoggedUser loggedUser;

    @Autowired
    public UserController(UserService userService, LoggedUser loggedUser) {
        this.userService = userService;
        this.loggedUser = loggedUser;
    }

    @GetMapping("/getAllUsers")
    public Iterable<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/getLoggedUser")
    public String getLoggedUser() {
        return ((UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    @GetMapping("/getAllUsersWithRole")
    public List<Object[]> getAllUsersWithRole() {
        return userService.findAllUsersWithRole();
    }
}

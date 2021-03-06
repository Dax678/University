package com.example.susziweb.Controller;

import com.example.susziweb.Service.MarkService;
import com.example.susziweb.Service.MessageService;
import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.View.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sushi-web/api")
public class AdminController {
    private final UserService userService;
    private final MarkService markService;
    private final MessageService messageService;

    @Autowired
    public AdminController(UserService userService, MarkService markService, MessageService messageService) {
        this.userService = userService;
        this.markService = markService;
        this.messageService = messageService;
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

    @GetMapping("/getUserMarks/{username}")
    public List<Object[]> getUserMarks(@PathVariable(name = "username") String username) {
        return markService.findUserMarks(userService.findUserByUsername(username));
    }

    @GetMapping("/getUserMessages/{username}")
    public List<UserMessage> getUserMessages(@PathVariable(name = "username") String username) {
        return messageService.findUserMessageByReceiver_name(userService.findUserByUsername(username));
    }

    @GetMapping("/getUserMessages")
    public List<UserMessage> getAllMessages() {
        return messageService.findAllMessages();
    }
}

package com.example.susziweb.Controller;

import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.Entity.User_details;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sushi-web/settings")
public class SettingsController {
    private final UserService userService;

    public SettingsController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String getView(Model model) {
        //Getting session username
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        //Getting Class of User
        User user = userService.findUserByUsername(username);

        //UserDetails - Name, Surname, picture, etc.
        User_details userDetailsByUsername = userService.findUserDetailsByUsername(username);
        model.addAttribute("user_details", userDetailsByUsername);

        //User - email
        model.addAttribute("email", user.getEmail());

        return "acc-settings";
    }

    //post new password
}

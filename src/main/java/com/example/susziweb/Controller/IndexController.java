package com.example.susziweb.Controller;

import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.Entity.User_details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/sushi-web")
public class IndexController {
    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping
    public String getMainView(Model model) {
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
        User user = userService.findUserByUsername(username);

        //UserDetails - album, year, picture, etc.
        User_details userDetailsByUsername = userService.findUserDetailsByUsername(username);
        model.addAttribute("user_details", userDetailsByUsername);

        List<Object[]> userSectionInfo = userService.findUserSectionInfo(
                userService.findUserByUsername(((UserDetails) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal())
                        .getUsername())
        );
        model.addAttribute("user_section_info", Arrays.stream(userSectionInfo.get(0)).toArray());

        /*model.addAttribute("user_messages", userService.findUserMessages(user));*/

        /*model.addAttribute("messages", userService.findAddressedToUserMessages(user));*/
        return "index";
    }
}
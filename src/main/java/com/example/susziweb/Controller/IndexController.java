package com.example.susziweb.Controller;

import com.example.susziweb.Service.MessageService;
import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.Entity.User_details;
import com.example.susziweb.db.View.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sushi-web")
public class IndexController {
    private final UserService userService;
    private final MessageService messageService;

    @Autowired
    public IndexController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping("/login")
    public String getLoginView() {
        return "login";
    }

    @GetMapping
    public String getMainView(Model model) {
        //Getting session username
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        //Getting Class of User
        User user = userService.findUserByUsername(username);

        //UserDetails - Name, Surname, picture, etc.
        User_details userDetailsByUsername = userService.findUserDetailsByUsername(username);
        model.addAttribute("user_details", userDetailsByUsername);

        //Getting album number, year, etc.
        List<Object[]> userSectionInfo = userService.findUserSectionInfo(
                userService.findUserByUsername(((UserDetails) SecurityContextHolder
                        .getContext()
                        .getAuthentication()
                        .getPrincipal())
                        .getUsername())
        );
        model.addAttribute("user_section_info", Arrays.stream(userSectionInfo.get(0)).toArray());

        //Getting messages - send last 3 messages
        model.addAttribute("messages",
                messageService.findUserMessageByReceiver_name(user)
                        .stream()
                        .sorted(Comparator.comparing(UserMessage::getSend_date))
                        .limit(3)
                        .collect(Collectors.toList())
        );

        return "index";
    }
}

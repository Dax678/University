package com.example.susziweb.Controller;

import com.example.susziweb.Service.MessageService;
import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.Entity.User;
import com.example.susziweb.db.View.UserMessage;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Comparator;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/sushi-web/message-archive")
public class MessageArchiveController {
    private final UserService userService;
    private final MessageService messageService;

    public MessageArchiveController(UserService userService, MessageService messageService) {
        this.userService = userService;
        this.messageService = messageService;
    }

    @GetMapping
    public String getView(Model model) {
        //Getting session username
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        //Getting Class of User
        User user = userService.findUserByUsername(username);
        model.addAttribute("username", user.getLogin());

        //Getting messages - send all Messages
        model.addAttribute("messages",
                messageService.findUserMessageByReceiver_name(user)
                        .stream()
                        .sorted(Comparator.comparing(UserMessage::getSend_date))
                        .collect(Collectors.toList())
        );

        return "message-archive";
    }
}

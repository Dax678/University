package com.example.susziweb.Controller;


import com.example.susziweb.Service.MarkService;
import com.example.susziweb.Service.TeachesService;
import com.example.susziweb.Service.UserService;
import com.example.susziweb.db.Entity.User;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/sushi-web/marks")
public class MarkController {
    private final UserService userService;
    private final TeachesService teachesService;
    private final MarkService markService;

    public MarkController(UserService userService, TeachesService teachesService, MarkService markService) {
        this.userService = userService;
        this.teachesService = teachesService;
        this.markService = markService;
    }

    @GetMapping
    public String getView(Model model) {
        //Getting session username
        String username = ((UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();

        //Getting Class of User
        User user = userService.findUserByUsername(username);

        //List of: subject, teacher
        List<Object[]> subjectInformations = markService.findUserMarks(userService.findUserByUsername(username));
        model.addAttribute("listOfSubAndTeachers", subjectInformations);

        return "marks";
    }
}

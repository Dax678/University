package com.example.susziweb.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sushi-web/last-courses")
public class LastCoursesController {
    @GetMapping
    public String getView() {
        return "last-courses";
    }
}
package com.example.susziweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sushi-web/lang-courses")
public class LangCoursesController {
    @GetMapping
    public String getView() {
        return "lang-courses";
    }
}

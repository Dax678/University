package com.example.susziweb.Controller;

import com.example.susziweb.Service.TeachesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sushi-web/lang-courses")
public class LangCoursesController {
    private final TeachesService teachesService;

    public LangCoursesController(TeachesService teachesService) {
        this.teachesService = teachesService;
    }

    @GetMapping
    public String getView(Model model) {

        model.addAttribute("langteaches",teachesService.findAllEnglishTeachers().toArray());

        return "lang-courses";
    }
}

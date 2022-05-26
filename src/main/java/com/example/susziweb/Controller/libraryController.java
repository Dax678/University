package com.example.susziweb.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sushi-web/library")
public class libraryController {
    @GetMapping
    public String getView() {
        return "library";
    }
}

package com.example.susziweb.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sushi-web/marks")
public class Marks {
    @GetMapping
    public String getView() {
        return "marks";
    }
}

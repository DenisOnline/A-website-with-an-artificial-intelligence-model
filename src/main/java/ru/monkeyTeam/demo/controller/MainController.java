package ru.monkeyTeam.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("title", "Главная страница");
        return "index";
    }

    @GetMapping("/model_road_sings")
    public String modelRoadSings(Model model) {
        model.addAttribute("title", "Дорожные знаки");
        return "model_road_sings";
    }

    @GetMapping("/model_cats")
    public String modelCats(Model model) {
        model.addAttribute("title", "Дорожные знаки");
        return "model_cats";
    }
}

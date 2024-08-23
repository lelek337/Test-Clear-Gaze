package com.example.testtask.controller;

import com.example.testtask.service.QuadraticEquationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuadraticEducationController {

    private final QuadraticEquationService quadraticEducationService;

    public QuadraticEducationController(QuadraticEquationService quadraticEducationService) {
        this.quadraticEducationService = quadraticEducationService;
    }

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("calculate")
    public String calculate(
            @RequestParam("a") double a,
            @RequestParam("b") double b,
            @RequestParam("c") double c,
            @RequestParam("y") double y,
            @RequestParam(value = "round", defaultValue = "false") boolean round,
            Model model) {

        double x = quadraticEducationService.calculateX(a, b, c, round);

        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("c", c);
        model.addAttribute("x", x);
        model.addAttribute("y", y);
        model.addAttribute("discriminant", quadraticEducationService.calculateDiscriminant(a, b, c));
        return "result";
    }
}
package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class TaskController {

    @GetMapping
    public String index(Model model) {
        model.addAttribute("title", "機能Aを作る");
        return "index";
    }
}

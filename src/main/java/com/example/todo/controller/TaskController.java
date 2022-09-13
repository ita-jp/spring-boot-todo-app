package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/")
@Controller
public class TaskController {

    @GetMapping
    public String index(Model model) {
        var taskList = List.of(
                new TaskDTO(1, "機能Aを実装する", true),
                new TaskDTO(2, "機能Bを実装する", false),
                new TaskDTO(3, "機能Cを実装する", false)
        );
        model.addAttribute("taskList", taskList);
        return "index";
    }
}

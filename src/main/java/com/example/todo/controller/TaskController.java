package com.example.todo.controller;

import com.example.todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class TaskController {

    private final TaskService taskService = new TaskService();

    @GetMapping
    public String index(Model model) {
        var taskList = taskService.findAll();
        model.addAttribute("taskList", taskList);
        return "index";
    }
}

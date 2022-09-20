package com.example.todo.controller;

import com.example.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public String index(Model model) {
        var taskList = taskService.findAll()
                .stream()
                .map(TaskDTO::toDTO)
                .toList();
        model.addAttribute("taskList", taskList);
        return "index";
    }

    @GetMapping("/tasks/new")
    public String showForm() {
        return "tasks/form";
    }

    @PostMapping("/tasks")
    public String createTask(TaskForm form, Model model) {
        return index(model); // TODO PRG pattern
    }
}

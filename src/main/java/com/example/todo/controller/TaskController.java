package com.example.todo.controller;

import com.example.todo.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    public String showForm(@ModelAttribute TaskForm form) {
        return "tasks/form";
    }

    @PostMapping("/tasks")
    public String createTask(@Validated TaskForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return showForm(form);
        }
        taskService.create(form.title());
        return "redirect:/";
    }

    @GetMapping("/tasks/{taskId}")
    public String show(@PathVariable("taskId") long taskId, Model model) {
        var taskEntity = taskService.find(taskId).get(); // TODO
        model.addAttribute("task", taskEntity);
        return "tasks/detail";
    }
}

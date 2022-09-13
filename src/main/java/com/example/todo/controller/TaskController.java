package com.example.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/")
@Controller
public class TaskController {

    @GetMapping
    @ResponseBody
    public String index() {
        return "<h1>Hello, world!!</h1>";
    }
}

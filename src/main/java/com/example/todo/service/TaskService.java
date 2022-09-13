package com.example.todo.service;

import com.example.todo.controller.TaskDTO;

import java.util.List;

public class TaskService {

    public List<TaskDTO> findAll() {
        return List.of(
                new TaskDTO(1, "機能Aを実装する", true),
                new TaskDTO(2, "機能Bを実装する", false),
                new TaskDTO(3, "機能Cを実装する", false)
        );
    }
}

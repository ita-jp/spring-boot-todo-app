package com.example.todo.service;

import java.util.List;

public class TaskService {

    public List<TaskEntity> findAll() {
        return List.of(
                new TaskEntity(1, "機能Aを実装する", true),
                new TaskEntity(2, "機能Bを実装する", false),
                new TaskEntity(3, "機能Cを実装する", false)
        );
    }
}

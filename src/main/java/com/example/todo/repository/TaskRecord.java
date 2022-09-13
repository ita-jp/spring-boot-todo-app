package com.example.todo.repository;

import lombok.Data;

@Data
public class TaskRecord {

    private Long taskId;
    private String title;
    private boolean isCompleted;

}

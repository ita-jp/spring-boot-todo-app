package com.example.todo.repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRecord {

    private Long taskId;
    private String title;
    private boolean isCompleted;

}

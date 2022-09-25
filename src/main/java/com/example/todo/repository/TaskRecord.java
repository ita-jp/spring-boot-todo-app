package com.example.todo.repository;

import com.example.todo.service.TaskEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TaskRecord {

    private Long taskId;
    private String title;
    private boolean isCompleted;

    public TaskEntity toEntity() {
        return new TaskEntity(taskId, title, isCompleted);
    }

}

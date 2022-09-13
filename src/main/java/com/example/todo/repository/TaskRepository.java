package com.example.todo.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TaskRepository {

    @Select("""
            SELECT
               task_id,
               title,
               is_completed
            FROM
               tasks
            """)
    List<TaskRecord> select();

}
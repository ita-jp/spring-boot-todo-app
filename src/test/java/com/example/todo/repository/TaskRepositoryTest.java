package com.example.todo.repository;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@MybatisTest
class TaskRepositoryTest {

    @Autowired
    private TaskRepository cut;

    @Test
    public void returnEmptyList() {
        // ## Act ##
        var actual = cut.select();

        // ## Assert ##
        assertThat(actual).isEmpty();
    }

    @Test
    @Sql(scripts = {
            "/sql/insert_tasks.sql"
    })
    public void returnList() {
        // ## Act ##
        var actual = cut.select();

        // ## Assert ##
        assertThat(actual).hasSize(2);
        assertThat(actual.get(0)).isEqualTo(new TaskRecord(1L, "__TITLE_1__", true));
        assertThat(actual.get(1)).isEqualTo(new TaskRecord(2L, "__TITLE_2__", false));
    }
}
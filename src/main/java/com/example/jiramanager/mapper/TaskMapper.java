package com.example.jiramanager.mapper;

import com.example.jiramanager.dto.TaskDto;
import com.example.jiramanager.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {
    public TaskDto convertToTaskDto(Task task) {
        return TaskDto.builder()
                .name(task.getName())
                .description(task.getDescription())
                .build();
    }
}

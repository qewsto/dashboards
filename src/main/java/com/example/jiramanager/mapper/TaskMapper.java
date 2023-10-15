package com.example.jiramanager.mapper;

import com.example.jiramanager.dto.TaskDto;
import com.example.jiramanager.entity.Task;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TaskMapper {
    public Mono<TaskDto> convertToTaskDto(Mono<Task> task) {
        return task.flatMap(t -> {
            final TaskDto taskDto = new TaskDto(t.getName(), t.getDescription());
            return Mono.just(taskDto);
        });
    }

    public Flux<TaskDto> convertTasksToDto(Flux<Task> tasks) {
        return tasks.map((u -> new TaskDto(u.getName(), u.getDescription())));
    }
}

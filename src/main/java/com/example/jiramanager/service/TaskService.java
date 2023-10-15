package com.example.jiramanager.service;

import com.example.jiramanager.dto.TaskDto;
import com.example.jiramanager.entity.Task;
import com.example.jiramanager.mapper.TaskMapper;
import com.example.jiramanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public Mono<TaskDto> getTask(UUID id) {
        Mono<Task> task = taskRepository.findById(id);
        return taskMapper.convertToTaskDto(task);
    }

    public Flux<TaskDto> getAllTasks() {
        return taskMapper.convertTasksToDto(taskRepository.findAll());
    }

    public void deleteTask(UUID id) {
        taskRepository.deleteById(id);
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }
}

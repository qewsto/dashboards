package com.example.jiramanager.service;

import com.example.jiramanager.dto.TaskDto;
import com.example.jiramanager.entity.Task;
import com.example.jiramanager.exception.TaskNotFound;
import com.example.jiramanager.mapper.TaskMapper;
import com.example.jiramanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    public TaskDto getTask(UUID id) {
        Task task = taskRepository.findById(id).orElseThrow(TaskNotFound::new);
        return taskMapper.convertToTaskDto(task);
    }

    public List<TaskDto> getAllTasks() {
        List<Task> tasks = taskRepository.findAll();
        List<TaskDto> taskDtoFlux = tasks.stream()
                .map(task-> {
                    return TaskDto.builder()
                            .name(task.getName())
                            .description(task.getDescription())
                            .build();
                })
                .collect(Collectors.toList());
        return taskDtoFlux;
    }

    public void deleteTask(UUID id) {
        taskRepository.delete(taskRepository.findById(id).get());
    }

    public void addTask(Task task) {
        taskRepository.save(task);
    }
}

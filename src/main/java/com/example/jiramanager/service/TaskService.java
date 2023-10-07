package com.example.jiramanager.service;

import com.example.jiramanager.entity.Task;
import com.example.jiramanager.exception.TaskNotFound;
import com.example.jiramanager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public Task getTask(UUID id) {
        return taskRepository.findById(id).orElseThrow(TaskNotFound::new);
    }
}

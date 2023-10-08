package com.example.jiramanager.controller;

import com.example.jiramanager.dto.TaskDto;
import com.example.jiramanager.entity.Task;
import com.example.jiramanager.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/task",
        produces = "application/json",
        consumes = "application/json")
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/{id}")
    public Mono<TaskDto> getTask(@PathVariable String id) {
        return Mono.just(taskService.getTask(UUID.fromString(id)));
    }

    @GetMapping("/all")
    public Flux<TaskDto> getTasks() {
        return Flux.fromIterable(taskService.getAllTasks());
    }

    @PostMapping("/add")
    public void addTask(@RequestBody Task task) {
        taskService.addTask(task);
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestBody UUID id) {
        taskService.deleteTask(id);
    }
}

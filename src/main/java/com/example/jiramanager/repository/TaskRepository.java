package com.example.jiramanager.repository;

import com.example.jiramanager.entity.Task;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TaskRepository extends ReactiveCrudRepository<Task, UUID> {
}

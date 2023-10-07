package com.example.jiramanager.exception;

public class TaskNotFound extends JiraException {
    public TaskNotFound() {
        super("Задача не была найдена");
    }
}

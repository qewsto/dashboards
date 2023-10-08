package com.example.jiramanager.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TaskDto {
    private String name;
    private String description;
}

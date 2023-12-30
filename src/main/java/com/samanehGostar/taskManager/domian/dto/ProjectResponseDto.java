package com.samanehGostar.taskManager.domian.dto;

import com.samanehGostar.taskManager.domian.entities.Task;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectResponseDto {
    private Long id;
    private String name;
    private String abbreviatedName;
    private UserResponseDto createdUser;
    private Set<TaskResponseDto> tasks;



}

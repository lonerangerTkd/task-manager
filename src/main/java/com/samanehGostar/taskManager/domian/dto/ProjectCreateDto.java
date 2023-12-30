package com.samanehGostar.taskManager.domian.dto;

import com.samanehGostar.taskManager.domian.entities.Task;
import com.samanehGostar.taskManager.domian.entities.User;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.Set;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProjectCreateDto {
    @NotEmpty
    private String name;
    @NotEmpty
    private String abbreviatedName;
    private UserResponseDto createdUser;


}

package com.samanehGostar.taskManager.domian.dto;

import com.samanehGostar.taskManager.domian.entities.Project;
import com.samanehGostar.taskManager.domian.entities.Task;
import com.samanehGostar.taskManager.domian.enumeration.Role;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    private Integer id;
    private String firstname;
    private String lastname;
    private Role role;
    private String username;
    private String password;
    private Set<Task> createdTasks;
    private Set<Task> assignedTasks;
    private Set<Project> createdProjects;
}

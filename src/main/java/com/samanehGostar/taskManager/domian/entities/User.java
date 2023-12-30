package com.samanehGostar.taskManager.domian.entities;

import com.samanehGostar.taskManager.domian.enumeration.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.Set;
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User   {
    @Id
    private Integer id;
    private String firstname;
    private String lastname;
    private Role role;
    private String username;
    private String password;
    @OneToMany
    private Set<Task> createdTasks;
    @OneToMany
    private Set<Task> assignedTasks;
    @OneToMany
    private Set<Project> createdProjects;

}


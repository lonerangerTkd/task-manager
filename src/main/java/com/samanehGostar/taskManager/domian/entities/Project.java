package com.samanehGostar.taskManager.domian.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Project {
    @Id
    private Long id;
    private String name;
    private String abbreviatedName;
    @ManyToOne
    private User createdUser;
    @OneToMany
    // TODO: 12/27/2023    mapping
    private Set<Task> tasks;

    // TODO: 12/27/2023   equal & hashcode
}

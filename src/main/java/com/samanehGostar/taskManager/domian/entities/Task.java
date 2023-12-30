package com.samanehGostar.taskManager.domian.entities;

import com.samanehGostar.taskManager.domian.enumeration.Priority;
import com.samanehGostar.taskManager.domian.enumeration.State;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

import javax.print.attribute.standard.DateTimeAtCreation;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Task {
    @Id
    private Long id;
    private String name;
    private Long taskNumber;
    private State state;
    private Priority priority;
    private LocalDateTime createDate;
    private LocalDateTime deadLineTime;
    private LocalDateTime completeDate;
    @ManyToOne
    private User createduser;
    @ManyToOne
    private User assignedUser;
    @OneToMany
    private Set<Task> subTask;
    // TODO: 12/27/2023  override equal & hashcode

}

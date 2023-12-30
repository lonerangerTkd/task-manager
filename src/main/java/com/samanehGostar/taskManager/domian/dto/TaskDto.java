package com.samanehGostar.taskManager.domian.dto;

import com.samanehGostar.taskManager.domian.enumeration.Priority;
import com.samanehGostar.taskManager.domian.enumeration.State;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TaskDto {
    private Long id;
    private String name;
    private Long taskNumber;
    private State state;
    private Priority priority;
    private LocalDateTime createDate;
    private LocalDateTime deadLineTime;
    private LocalDateTime completeDate;
    private UserResponseDto createdUser;
    private UserResponseDto assignedUser;
    private Set<TaskResponseDto> subTask;
}

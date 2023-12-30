package com.samanehGostar.taskManager.service;

import com.samanehGostar.taskManager.repository.ProjectRepository;
import com.samanehGostar.taskManager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public
class TaskService {

    private final TaskRepository taskRepository;
    private final UserDetails userDetails;

}

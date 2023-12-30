package com.samanehGostar.taskManager.service;

import com.samanehGostar.taskManager.repository.ProjectRepository;
import com.samanehGostar.taskManager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {


    private final ProjectRepository projectRepository;

    // TODO: 12/27/2023 create
    // TODO: 12/27/2023 read;
    // TODO: 12/27/2023 update
    // TODO: 12/27/2023 delete

}

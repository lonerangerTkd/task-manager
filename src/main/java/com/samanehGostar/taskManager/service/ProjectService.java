package com.samanehGostar.taskManager.service;

import com.samanehGostar.taskManager.domian.dto.*;
import com.samanehGostar.taskManager.domian.entities.Project;
import com.samanehGostar.taskManager.domian.entities.Task;
import com.samanehGostar.taskManager.domian.entities.User;
import com.samanehGostar.taskManager.repository.ProjectRepository;
import com.samanehGostar.taskManager.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import org.hibernate.ObjectNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProjectService {


    private final ProjectRepository projectRepository;

    private final Authentication authentication;
    private final UserService userService;

    @Transactional
    public void createProject(ProjectCreateDto projectCreateDto) {
        UserResponseDto userResponseDto = userService
                .findBydUsername(authentication.getName());
        projectCreateDto.setCreatedUser(userResponseDto);
        projectRepository.save(mapToEntity(projectCreateDto));


    }

    public ProjectResponseDto findById(Long id) {
        Optional<Project> project = projectRepository.findById(id);
        if (project.isEmpty()){
            throw new ObjectNotFoundException("project",project);
        }else
             return  mapToProjectResponseDto(project.get());

    }
    public List<ProjectResponseDto> getAllProjects(){
        List<Project> allProjects = projectRepository.findAll();
       return   allProjects.stream()
                .map(this::mapToProjectResponseDto)
                .collect(Collectors.toList());
    }
    private ProjectResponseDto mapToProjectResponseDto(Project project) {
        return ProjectResponseDto.builder()
                .name(project.getName())
                .abbreviatedName(project.getAbbreviatedName())
                .id(project.getId())
                .tasks(project
                        .getTasks()
                        .stream()
                        .map(task -> TaskResponseDto.builder()
                                .id(task.getId())
                                .assignedUser(UserResponseDto.builder()
                                        .firstname(task.getAssignedUser().getFirstname())
                                        .lastname(task.getAssignedUser().getLastname())
                                        .username(task.getAssignedUser().getUsername())
                                        .role(task.getAssignedUser().getRole())
                                        .id(task.getAssignedUser().getId()).build())
                                .build())
                        .collect(Collectors.toSet()))
                .build();
    }

    private Project mapToEntity(ProjectCreateDto projectCreateDto) {
        return Project.builder()
                .name(projectCreateDto.getName())
                .createdUser(User.builder()
                        .id(projectCreateDto
                                .getCreatedUser()
                                .getId())
                        .build())
                .abbreviatedName(projectCreateDto.getAbbreviatedName())
                .build();
    }

    // TODO: 12/27/2023 create
    // TODO: 12/27/2023 read;
    // TODO: 12/27/2023 update
    // TODO: 12/27/2023 delete

}

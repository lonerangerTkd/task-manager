package com.samanehGostar.taskManager.controller;
import com.samanehGostar.taskManager.domian.dto.ProjectCreateDto;
import com.samanehGostar.taskManager.domian.dto.ProjectResponseDto;
import com.samanehGostar.taskManager.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {
  private final ProjectService projectService;
      @PostMapping("create-project")
      @ResponseStatus(HttpStatus.CREATED)
      public void createProject(@RequestBody @Validated ProjectCreateDto projectCreateDto)  {
        projectService.createProject(projectCreateDto);
      }
    @GetMapping("get-project")
    @ResponseStatus(HttpStatus.OK)
    public ProjectResponseDto getProjectById(@RequestParam Long id){
         return projectService.findById(id);
    }

      // TODO: 12/27/2023 update
  // TODO: 12/27/2023 delete
}

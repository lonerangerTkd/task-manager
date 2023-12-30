package com.samanehGostar.taskManager.controller;
import com.samanehGostar.taskManager.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/project")
@RequiredArgsConstructor
public class ProjectController {
  private final ProjectService projectService;

  // TODO: 12/27/2023 create
  // TODO: 12/27/2023 read;
  // TODO: 12/27/2023 update
  // TODO: 12/27/2023 delete
}

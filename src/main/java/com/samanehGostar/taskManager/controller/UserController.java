package com.samanehGostar.taskManager.controller;

import com.samanehGostar.taskManager.domian.dto.UserCreateDto;
import com.samanehGostar.taskManager.domian.dto.UserDto;
import com.samanehGostar.taskManager.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {

private final UserService userService;
    @PostMapping("/create-user")
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasAuthority('admin:create')")
    public void createUser(@RequestBody @Validated UserCreateDto userCreateDto){
        userService.createUser(userCreateDto);
    }

    @PutMapping("delete-user")
    @ResponseStatus(HttpStatus.OK)
    @PreAuthorize("hasAuthority('admin:create')")
    public void deleteById(@RequestParam Integer id){
        userService.deleteUserById(id);
    }


}

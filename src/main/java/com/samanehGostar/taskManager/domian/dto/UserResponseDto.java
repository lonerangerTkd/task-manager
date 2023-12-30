package com.samanehGostar.taskManager.domian.dto;

import com.samanehGostar.taskManager.domian.entities.Project;
import com.samanehGostar.taskManager.domian.entities.Task;
import com.samanehGostar.taskManager.domian.enumeration.Role;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
     private Integer id;
    private String firstname;
    private String lastname;
    private Role role;
    private String username;
}

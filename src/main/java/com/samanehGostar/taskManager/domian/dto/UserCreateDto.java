package com.samanehGostar.taskManager.domian.dto;

import com.samanehGostar.taskManager.domian.enumeration.Role;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto {

    private String firstname;
    private String lastname;
    private Role role;
    private String username;
    private String password;
}

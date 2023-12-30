package com.samanehGostar.taskManager.domian.dto;

import com.samanehGostar.taskManager.domian.enumeration.Role;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserCreateDto {
    @NotEmpty
    private String firstname;
    @NotEmpty
    private String lastname;
    @NotEmpty
    private Role role;
    @NotEmpty
    private String username;
    @NotEmpty()
    private String password;
    @NotEmpty
    private boolean isAccountNonLocked;
    @NotEmpty
    private boolean isAccountNonExpired;
    @NotEmpty
    private boolean isCredentialsNonExpired;
    @NotEmpty
    private boolean isEnabled;
    private Set<SimpleGrantedAuthority> authorities;
}

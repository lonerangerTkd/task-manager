package com.samanehGostar.taskManager.service;

import com.samanehGostar.taskManager.domian.dto.TaskDto;
import com.samanehGostar.taskManager.domian.dto.UserCreateDto;
import com.samanehGostar.taskManager.domian.dto.UserDto;
import com.samanehGostar.taskManager.domian.dto.UserResponseDto;
import com.samanehGostar.taskManager.domian.entities.User;
import com.samanehGostar.taskManager.repository.UserRepository;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.Set;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void createUser(UserCreateDto userCreateDto) {
        userCreateDto.setPassword(passwordEncoder
                .encode(userCreateDto.getPassword()));
        userRepository
                .save(mapToUser(userCreateDto));

    }

    public UserDto findById(Integer id) {
        Optional<User> user = Optional
                .of(userRepository.findById(id)
                        .orElseThrow());
        return mapToDto(user.get());
    }

    public UserDto findByUserName(String username) {
        return mapToDto(userRepository.findByUsername(username));
    }

    @Transactional
    public void deleteUserById(Integer id) {
        UserDto userDto = findById(id);
        userDto.setEnabled(false);
        userRepository.saveAndFlush(mapToUser(userDto));
    }

    public UserResponseDto findBydUsername(String username){
        return mapToUserResponseDto(userRepository.findByUsername(username));
    }


    private User mapToUser(UserCreateDto userCreateDto) {
        return User
                .builder()
                .firstname(userCreateDto.getFirstname())
                .lastname(userCreateDto.getLastname())
                .role(userCreateDto.getRole())
                .username(userCreateDto.getUsername())
                .password(userCreateDto.getPassword())
                .isAccountNonLocked(userCreateDto.isAccountNonLocked())
                .isAccountNonExpired(userCreateDto.isAccountNonExpired())
                .isEnabled(userCreateDto.isEnabled())
                .isCredentialsNonExpired(userCreateDto.isCredentialsNonExpired())
                .authorities(userCreateDto.getRole().getAuthorities())
                .build();
    }
    // TODO: 12/30/2023 authorities??

    public User mapToUser(UserDto userDto) {
        return User
                .builder()
                .firstname(userDto.getFirstname())
                .lastname(userDto.getLastname())
                .role(userDto.getRole())
                .username(userDto.getUsername())
                .password(userDto.getPassword())
                .isAccountNonLocked(userDto.isAccountNonLocked())
                .isAccountNonExpired(userDto.isAccountNonExpired())
                .isEnabled(userDto.isEnabled())
                .isCredentialsNonExpired(userDto.isCredentialsNonExpired())
                .build();
    }


    private UserDto mapToDto(User user) {
        return UserDto.builder()
                .firstname(user.getFirstname())
                .lastname(user.getLastname())
                .username(user.getUsername())
                .createdProjects(user.getCreatedProjects())
                .createdTasks(user.getCreatedTasks())
                .id(user.getId())
                .password(user.getPassword())
                .assignedTasks(user.getAssignedTasks())
                .role(user.getRole())
                .isAccountNonLocked(user.isAccountNonLocked())
                .isAccountNonExpired(user.isAccountNonExpired())
                .isEnabled(user.isEnabled())
                .isCredentialsNonExpired(user.isCredentialsNonExpired())
                .authorities(user.getRole().getAuthorities())

                .build();
    }
        private UserResponseDto mapToUserResponseDto(User user){

            return UserResponseDto.builder()
                    .firstname(user.getFirstname())
                    .lastname(user.getLastname())
                    .username(user.getUsername())
                    .id(user.getId())
                    .role(user.getRole())
                    .build();

        }



}

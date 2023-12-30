package com.samanehGostar.taskManager.service;

import com.samanehGostar.taskManager.domian.dto.UserCreateDto;
import com.samanehGostar.taskManager.domian.dto.UserDto;
import com.samanehGostar.taskManager.domian.entities.User;
import com.samanehGostar.taskManager.repository.UserRepository;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    private void createUser (UserCreateDto userCreateDto){
        userRepository.save(mapToUser(userCreateDto));

    }
    private UserDto findById(Integer id){
        userRepository.findById(id);
        // TODO: 12/27/2023 return
        return null;
    }
    private User mapToUser(UserCreateDto userCreateDto){
        return User
                .builder()
                .firstname(userCreateDto.getFirstname())
                .lastname(userCreateDto.getLastname())
                .role(userCreateDto.getRole())
                .username(userCreateDto.getUsername())
                .password(userCreateDto.getPassword())
        .build();
    }

    // TODO: 12/27/2023 create
    // TODO: 12/27/2023 read;
    // TODO: 12/27/2023 update
    // TODO: 12/27/2023 delete

}

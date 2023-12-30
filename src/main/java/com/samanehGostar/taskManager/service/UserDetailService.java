package com.samanehGostar.taskManager.service;

import com.samanehGostar.taskManager.domian.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {
    private final UserService userService;
    private UserDto userDto;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         userDto = userService.findByUserName(username);
            if (userDto==null){
                throw new UsernameNotFoundException("wrong username or password");
            }

            return User.withUsername(username)
                    .password(userDto.getPassword())
                    .authorities(userDto.getRole().getAuthorities()).build();
    }
}

package com.samanehGostar.taskManager.domian.enumeration;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.samanehGostar.taskManager.domian.enumeration.UserPermission.*;


public enum Role {
    ADMIN(Sets.newHashSet(CREATE_TASK, UPDATE_TASK, READ_TASK, DELETE_TASK)),
    DEVELOPER(Sets.newHashSet(READ_TASK, UPDATE_TASK));


    private final Set<UserPermission> permissions;

    Role(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }
    public Set<UserPermission> getPermissions(){
        return this.permissions;
    }
    public Set<SimpleGrantedAuthority> getAuthorities() {
        Set<SimpleGrantedAuthority> permissions = getPermissions().
                parallelStream().
                map(permission -> new SimpleGrantedAuthority(permission
                        .getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;

    }


}

package com.samanehGostar.taskManager.domian.enumeration;

import com.google.common.collect.Sets;
import lombok.Getter;

import java.util.Set;

import static com.samanehGostar.taskManager.domian.enumeration.UserPermission.*;
@Getter
public enum Role {
    ADMIN(Sets.newHashSet( CREATE_TASK,UPDATE_TASK,READ_TASK,DELETE_TASK )),
    DEVELOPER(Sets.newHashSet(READ_TASK,UPDATE_TASK));


    private final Set<UserPermission> permissions;

    Role(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }


}

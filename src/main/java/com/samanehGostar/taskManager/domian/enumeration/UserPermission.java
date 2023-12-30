package com.samanehGostar.taskManager.domian.enumeration;

import lombok.Getter;

@Getter
public enum UserPermission {
    READ_TASK("developer:read"),
    CREATE_TASK("admin:create"),
    UPDATE_TASK("developer:update"),
    DELETE_TASK("admin:delete");

    private final String permission;


    UserPermission(String permission) {
        this.permission = permission;
    }


}

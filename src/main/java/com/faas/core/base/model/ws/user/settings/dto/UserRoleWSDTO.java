package com.faas.core.base.model.ws.user.settings.dto;

import com.faas.core.base.model.db.user.settings.UserRoleDBModel;

public class UserRoleWSDTO {

    private UserRoleDBModel userRole;

    public UserRoleWSDTO() {
    }

    public UserRoleWSDTO(UserRoleDBModel userRole) {
        this.userRole = userRole;
    }

    public UserRoleDBModel getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRoleDBModel userRole) {
        this.userRole = userRole;
    }
}

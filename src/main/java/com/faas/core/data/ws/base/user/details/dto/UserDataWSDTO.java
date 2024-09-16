package com.faas.core.data.ws.base.user.details.dto;

import com.faas.core.data.db.user.details.dao.UserDataDAO;

public class UserDataWSDTO {

    private UserDataDAO userData;

    public UserDataWSDTO() {
    }

    public UserDataWSDTO(UserDataDAO userData) {
        this.userData = userData;
    }

    public UserDataDAO getUserData() {
        return userData;
    }

    public void setUserData(UserDataDAO userData) {
        this.userData = userData;
    }
}

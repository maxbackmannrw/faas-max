package com.faas.core.base.model.ws.user.details.dto;

import com.faas.core.data.db.user.content.UserDBModel;
import com.faas.core.data.db.user.details.UserDetailsDBModel;


public class UserDetailsWSDTO {

    private UserDBModel user;
    private UserDetailsDBModel userDetails;

    public UserDetailsWSDTO() {
    }

    public UserDetailsWSDTO(UserDBModel user, UserDetailsDBModel userDetails) {
        this.user = user;
        this.userDetails = userDetails;
    }

    public UserDBModel getUser() {
        return user;
    }

    public void setUser(UserDBModel user) {
        this.user = user;
    }

    public UserDetailsDBModel getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsDBModel userDetails) {
        this.userDetails = userDetails;
    }
}

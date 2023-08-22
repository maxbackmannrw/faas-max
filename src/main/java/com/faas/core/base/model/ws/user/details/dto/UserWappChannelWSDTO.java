package com.faas.core.base.model.ws.user.details.dto;


import com.faas.core.base.model.db.user.details.dao.UserWappChannelDAO;

public class UserWappChannelWSDTO {

    private UserWappChannelDAO userWappChannel;

    public UserWappChannelWSDTO() {
    }

    public UserWappChannelWSDTO(UserWappChannelDAO userWappChannel) {
        this.userWappChannel = userWappChannel;
    }

    public UserWappChannelDAO getUserWappChannel() {
        return userWappChannel;
    }

    public void setUserWappChannel(UserWappChannelDAO userWappChannel) {
        this.userWappChannel = userWappChannel;
    }
}

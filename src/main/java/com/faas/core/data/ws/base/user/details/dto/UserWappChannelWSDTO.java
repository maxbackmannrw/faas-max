package com.faas.core.data.ws.base.user.details.dto;


import com.faas.core.data.db.user.details.dao.UserWappChannelDAO;

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

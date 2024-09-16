package com.faas.core.data.ws.base.user.details.dto;

import com.faas.core.data.db.user.details.dao.UserSipChannelDAO;

public class UserSipChannelWSDTO {

    private UserSipChannelDAO userSipChannel;

    public UserSipChannelWSDTO() {
    }

    public UserSipChannelWSDTO(UserSipChannelDAO userSipChannel) {
        this.userSipChannel = userSipChannel;
    }

    public UserSipChannelDAO getUserSipChannel() {
        return userSipChannel;
    }

    public void setUserSipChannel(UserSipChannelDAO userSipChannel) {
        this.userSipChannel = userSipChannel;
    }
}

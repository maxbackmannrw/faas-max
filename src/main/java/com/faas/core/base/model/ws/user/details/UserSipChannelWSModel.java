package com.faas.core.base.model.ws.user.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.details.dto.UserSipChannelWSDTO;


public class UserSipChannelWSModel {

    private GeneralWSModel general;
    private UserSipChannelWSDTO userSipChannel;


    public UserSipChannelWSModel() {
    }

    public UserSipChannelWSModel(GeneralWSModel general, UserSipChannelWSDTO userSipChannel) {
        this.general = general;
        this.userSipChannel = userSipChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public UserSipChannelWSDTO getUserSipChannel() {
        return userSipChannel;
    }

    public void setUserSipChannel(UserSipChannelWSDTO userSipChannel) {
        this.userSipChannel = userSipChannel;
    }
}

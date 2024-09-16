package com.faas.core.data.ws.base.user.details;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.user.details.dto.UserDetailsWSDTO;

public class UserDetailsWSModel {

    private GeneralWSModel general;
    private UserDetailsWSDTO userDetails;

    public UserDetailsWSModel() {
    }

    public UserDetailsWSModel(GeneralWSModel general, UserDetailsWSDTO userDetails) {
        this.general = general;
        this.userDetails = userDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public UserDetailsWSDTO getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetailsWSDTO userDetails) {
        this.userDetails = userDetails;
    }
}

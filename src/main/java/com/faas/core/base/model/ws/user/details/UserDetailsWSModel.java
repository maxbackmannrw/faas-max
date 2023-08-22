package com.faas.core.base.model.ws.user.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.details.dto.UserDetailsWSDTO;

import java.util.List;

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

package com.faas.core.base.model.ws.user.settings;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.settings.dto.UserRoleWSDTO;

import java.util.List;

public class UserRoleWSModel {

    private GeneralWSModel general;
    private List<UserRoleWSDTO> userRoles;


    public UserRoleWSModel() {
    }

    public UserRoleWSModel(GeneralWSModel general, List<UserRoleWSDTO> userRoles) {
        this.general = general;
        this.userRoles = userRoles;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<UserRoleWSDTO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRoleWSDTO> userRoles) {
        this.userRoles = userRoles;
    }
}

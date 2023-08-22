package com.faas.core.base.model.ws.user.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.content.dto.UserWSDTO;

import java.util.List;

public class UserWSModel {

    private GeneralWSModel general;
    private List<UserWSDTO> users;


    public UserWSModel() {
    }

    public UserWSModel(GeneralWSModel general, List<UserWSDTO> users) {
        this.general = general;
        this.users = users;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<UserWSDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserWSDTO> users) {
        this.users = users;
    }
}

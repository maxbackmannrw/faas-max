package com.faas.core.data.ws.base.user.content;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.user.content.dto.UserWSDTO;

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

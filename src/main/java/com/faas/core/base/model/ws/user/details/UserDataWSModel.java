package com.faas.core.base.model.ws.user.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.user.details.dto.UserDataWSDTO;

import java.util.List;

public class UserDataWSModel {

    private GeneralWSModel general;
    private List<UserDataWSDTO>userDatas;


    public UserDataWSModel() {
    }

    public UserDataWSModel(GeneralWSModel general, List<UserDataWSDTO> userDatas) {
        this.general = general;
        this.userDatas = userDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<UserDataWSDTO> getUserDatas() {
        return userDatas;
    }

    public void setUserDatas(List<UserDataWSDTO> userDatas) {
        this.userDatas = userDatas;
    }
}

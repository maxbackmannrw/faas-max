package com.faas.core.api.model.ws.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiPushMessageWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiPushAccountWSModel {

    private GeneralWSModel general;
    private List<ApiPushMessageWSDTO> pushMessages;

    public ApiPushAccountWSModel() {
    }

    public ApiPushAccountWSModel(GeneralWSModel general, List<ApiPushMessageWSDTO> pushMessages) {
        this.general = general;
        this.pushMessages = pushMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiPushMessageWSDTO> getPushMessages() {
        return pushMessages;
    }

    public void setPushMessages(List<ApiPushMessageWSDTO> pushMessages) {
        this.pushMessages = pushMessages;
    }
}

package com.faas.core.api.model.ws.operation.details.channel.message.push;

import com.faas.core.api.model.ws.operation.details.channel.message.push.dto.ApiOperationPushWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;


public class ApiOperationPushWSModel {

    private GeneralWSModel general;
    private List<ApiOperationPushWSDTO> pushMessages;

    public ApiOperationPushWSModel() {
    }

    public ApiOperationPushWSModel(GeneralWSModel general, List<ApiOperationPushWSDTO> pushMessages) {
        this.general = general;
        this.pushMessages = pushMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ApiOperationPushWSDTO> getPushMessages() {
        return pushMessages;
    }

    public void setPushMessages(List<ApiOperationPushWSDTO> pushMessages) {
        this.pushMessages = pushMessages;
    }
}

package com.faas.core.base.model.ws.operation.details.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.details.channel.dto.OperationPushMessageWSDTO;

import java.util.List;

public class OperationPushMessageWSModel {

    private GeneralWSModel general;
    private List<OperationPushMessageWSDTO>pushMessages;

    public OperationPushMessageWSModel() {
    }

    public OperationPushMessageWSModel(GeneralWSModel general, List<OperationPushMessageWSDTO> pushMessages) {
        this.general = general;
        this.pushMessages = pushMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<OperationPushMessageWSDTO> getPushMessages() {
        return pushMessages;
    }

    public void setPushMessages(List<OperationPushMessageWSDTO> pushMessages) {
        this.pushMessages = pushMessages;
    }
}

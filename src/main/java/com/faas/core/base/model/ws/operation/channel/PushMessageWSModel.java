package com.faas.core.base.model.ws.operation.channel;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.operation.channel.dto.PushMessageWSDTO;

import java.util.List;

public class PushMessageWSModel {

    private GeneralWSModel general;
    private List<PushMessageWSDTO>pushMessages;

    public PushMessageWSModel() {
    }

    public PushMessageWSModel(GeneralWSModel general, List<PushMessageWSDTO> pushMessages) {
        this.general = general;
        this.pushMessages = pushMessages;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<PushMessageWSDTO> getPushMessages() {
        return pushMessages;
    }

    public void setPushMessages(List<PushMessageWSDTO> pushMessages) {
        this.pushMessages = pushMessages;
    }
}

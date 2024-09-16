package com.faas.core.data.ws.base.channel.settings;

import com.faas.core.data.ws.base.channel.settings.dto.MessageTypeWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class MessageTypeWSModel {

    private GeneralWSModel general;
    private List<MessageTypeWSDTO> messageTypes;


    public MessageTypeWSModel() {
    }


    public MessageTypeWSModel(GeneralWSModel general, List<MessageTypeWSDTO> messageTypes) {
        this.general = general;
        this.messageTypes = messageTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<MessageTypeWSDTO> getMessageTypes() {
        return messageTypes;
    }

    public void setMessageTypes(List<MessageTypeWSDTO> messageTypes) {
        this.messageTypes = messageTypes;
    }
}

package com.faas.core.base.model.ws.channel.settings.dto;

import com.faas.core.data.db.channel.settings.MessageTypeDBModel;

public class MessageTypeWSDTO {

    private MessageTypeDBModel messageType;

    public MessageTypeWSDTO() {
    }

    public MessageTypeWSDTO(MessageTypeDBModel messageType) {
        this.messageType = messageType;
    }

    public MessageTypeDBModel getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageTypeDBModel messageType) {
        this.messageType = messageType;
    }
}

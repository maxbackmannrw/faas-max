package com.faas.core.base.model.ws.process.details.channel.content.dto;

import com.faas.core.base.model.db.process.details.channel.content.ProcessEmailChannelDBModel;

public class ProcessEmailChannelWSDTO {

    private ProcessEmailChannelDBModel emailChannel;

    public ProcessEmailChannelWSDTO() {
    }

    public ProcessEmailChannelWSDTO(ProcessEmailChannelDBModel emailChannel) {
        this.emailChannel = emailChannel;
    }

    public ProcessEmailChannelDBModel getEmailChannel() {
        return emailChannel;
    }

    public void setEmailChannel(ProcessEmailChannelDBModel emailChannel) {
        this.emailChannel = emailChannel;
    }
}

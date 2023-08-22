package com.faas.core.base.model.ws.process.details.channel.content.dto;

import com.faas.core.base.model.db.process.details.channel.content.ProcessSipChannelDBModel;

public class ProcessSipChannelWSDTO {

    private ProcessSipChannelDBModel sipChannel;

    public ProcessSipChannelWSDTO() {
    }

    public ProcessSipChannelWSDTO(ProcessSipChannelDBModel sipChannel) {
        this.sipChannel = sipChannel;
    }

    public ProcessSipChannelDBModel getSipChannel() {
        return sipChannel;
    }

    public void setSipChannel(ProcessSipChannelDBModel sipChannel) {
        this.sipChannel = sipChannel;
    }
}

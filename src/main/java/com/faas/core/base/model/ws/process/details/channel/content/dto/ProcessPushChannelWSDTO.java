package com.faas.core.base.model.ws.process.details.channel.content.dto;

import com.faas.core.base.model.db.process.details.channel.content.ProcessPushChannelDBModel;

public class ProcessPushChannelWSDTO {

    private ProcessPushChannelDBModel pushChannel;

    public ProcessPushChannelWSDTO() {
    }

    public ProcessPushChannelWSDTO(ProcessPushChannelDBModel pushChannel) {
        this.pushChannel = pushChannel;
    }

    public ProcessPushChannelDBModel getPushChannel() {
        return pushChannel;
    }

    public void setPushChannel(ProcessPushChannelDBModel pushChannel) {
        this.pushChannel = pushChannel;
    }
}

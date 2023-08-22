package com.faas.core.base.model.ws.process.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessPushChannelWSDTO;

public class ProcessPushChannelWSModel {

    private GeneralWSModel general;
    private ProcessPushChannelWSDTO processPushChannel;

    public ProcessPushChannelWSModel() {
    }

    public ProcessPushChannelWSModel(GeneralWSModel general, ProcessPushChannelWSDTO processPushChannel) {
        this.general = general;
        this.processPushChannel = processPushChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessPushChannelWSDTO getProcessPushChannel() {
        return processPushChannel;
    }

    public void setProcessPushChannel(ProcessPushChannelWSDTO processPushChannel) {
        this.processPushChannel = processPushChannel;
    }
}

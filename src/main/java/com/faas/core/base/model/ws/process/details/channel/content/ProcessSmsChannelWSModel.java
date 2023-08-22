package com.faas.core.base.model.ws.process.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessSmsChannelWSDTO;

public class ProcessSmsChannelWSModel {

    private GeneralWSModel general;
    private ProcessSmsChannelWSDTO processSmsChannel;


    public ProcessSmsChannelWSModel() {
    }

    public ProcessSmsChannelWSModel(GeneralWSModel general, ProcessSmsChannelWSDTO processSmsChannel) {
        this.general = general;
        this.processSmsChannel = processSmsChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessSmsChannelWSDTO getProcessSmsChannel() {
        return processSmsChannel;
    }

    public void setProcessSmsChannel(ProcessSmsChannelWSDTO processSmsChannel) {
        this.processSmsChannel = processSmsChannel;
    }
}

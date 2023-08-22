package com.faas.core.base.model.ws.process.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessSipChannelWSDTO;

public class ProcessSipChannelWSModel {

    private GeneralWSModel general;
    private ProcessSipChannelWSDTO processSipChannel;


    public ProcessSipChannelWSModel() {
    }

    public ProcessSipChannelWSModel(GeneralWSModel general, ProcessSipChannelWSDTO processSipChannel) {
        this.general = general;
        this.processSipChannel = processSipChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessSipChannelWSDTO getProcessSipChannel() {
        return processSipChannel;
    }

    public void setProcessSipChannel(ProcessSipChannelWSDTO processSipChannel) {
        this.processSipChannel = processSipChannel;
    }
}

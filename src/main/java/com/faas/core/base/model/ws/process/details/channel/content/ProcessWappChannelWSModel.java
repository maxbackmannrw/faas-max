package com.faas.core.base.model.ws.process.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessWappChannelWSDTO;

public class ProcessWappChannelWSModel {

    private GeneralWSModel general;
    private ProcessWappChannelWSDTO processWappChannel;

    public ProcessWappChannelWSModel() {
    }

    public ProcessWappChannelWSModel(GeneralWSModel general, ProcessWappChannelWSDTO processWappChannel) {
        this.general = general;
        this.processWappChannel = processWappChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessWappChannelWSDTO getProcessWappChannel() {
        return processWappChannel;
    }

    public void setProcessWappChannel(ProcessWappChannelWSDTO processWappChannel) {
        this.processWappChannel = processWappChannel;
    }
}

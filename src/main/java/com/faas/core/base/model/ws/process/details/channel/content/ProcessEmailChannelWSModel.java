package com.faas.core.base.model.ws.process.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessEmailChannelWSDTO;

public class ProcessEmailChannelWSModel {

    private GeneralWSModel general;
    private ProcessEmailChannelWSDTO processEmailChannel;


    public ProcessEmailChannelWSModel() {
    }

    public ProcessEmailChannelWSModel(GeneralWSModel general, ProcessEmailChannelWSDTO processEmailChannel) {
        this.general = general;
        this.processEmailChannel = processEmailChannel;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessEmailChannelWSDTO getProcessEmailChannel() {
        return processEmailChannel;
    }

    public void setProcessEmailChannel(ProcessEmailChannelWSDTO processEmailChannel) {
        this.processEmailChannel = processEmailChannel;
    }
}

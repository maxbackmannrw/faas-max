package com.faas.core.base.model.ws.process.details.channel.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.channel.content.dto.ProcessChannelWSDTO;


public class ProcessChannelWSModel {

    private GeneralWSModel general;
    private ProcessChannelWSDTO processChannels;

    public ProcessChannelWSModel() {
    }

    public ProcessChannelWSModel(GeneralWSModel general, ProcessChannelWSDTO processChannels) {
        this.general = general;
        this.processChannels = processChannels;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ProcessChannelWSDTO getProcessChannels() {
        return processChannels;
    }

    public void setProcessChannels(ProcessChannelWSDTO processChannels) {
        this.processChannels = processChannels;
    }
}

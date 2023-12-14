package com.faas.core.base.model.ws.process.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessDataWSDTO;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessRemoteWSDTO;

import java.util.List;

public class ProcessRemoteWSModel {

    private GeneralWSModel general;
    private List<ProcessRemoteWSDTO>processRemotes;

    public ProcessRemoteWSModel() {
    }

    public ProcessRemoteWSModel(GeneralWSModel general, List<ProcessRemoteWSDTO> processRemotes) {
        this.general = general;
        this.processRemotes = processRemotes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessRemoteWSDTO> getProcessRemotes() {
        return processRemotes;
    }

    public void setProcessRemotes(List<ProcessRemoteWSDTO> processRemotes) {
        this.processRemotes = processRemotes;
    }
}

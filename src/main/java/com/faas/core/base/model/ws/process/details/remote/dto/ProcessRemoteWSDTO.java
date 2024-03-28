package com.faas.core.base.model.ws.process.details.remote.dto;

import com.faas.core.base.model.db.process.details.remote.ProcessRemoteDBModel;

public class ProcessRemoteWSDTO {

    private ProcessRemoteDBModel processRemote;

    public ProcessRemoteWSDTO() {
    }

    public ProcessRemoteWSDTO(ProcessRemoteDBModel processRemote) {
        this.processRemote = processRemote;
    }

    public ProcessRemoteDBModel getProcessRemote() {
        return processRemote;
    }

    public void setProcessRemote(ProcessRemoteDBModel processRemote) {
        this.processRemote = processRemote;
    }
}

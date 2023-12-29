package com.faas.core.base.model.ws.process.details.remote.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessRemoteDAO;

public class ProcessRemoteWSDTO {

    private ProcessRemoteDAO processRemote;

    public ProcessRemoteWSDTO() {
    }

    public ProcessRemoteWSDTO(ProcessRemoteDAO processRemote) {
        this.processRemote = processRemote;
    }

    public ProcessRemoteDAO getProcessRemote() {
        return processRemote;
    }

    public void setProcessRemote(ProcessRemoteDAO processRemote) {
        this.processRemote = processRemote;
    }
}

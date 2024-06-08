package com.faas.core.base.model.ws.process.details.remote.dto;

import com.faas.core.base.model.db.process.details.remote.ProcessRemoteDBModel;
import com.faas.core.base.model.db.utils.config.UrlDBModel;

import java.util.List;

public class ProcessRemoteWSDTO {

    private ProcessRemoteDBModel processRemote;
    private List<UrlDBModel> processRemoteUrls;

    public ProcessRemoteWSDTO() {
    }

    public ProcessRemoteWSDTO(ProcessRemoteDBModel processRemote, List<UrlDBModel> processRemoteUrls) {
        this.processRemote = processRemote;
        this.processRemoteUrls = processRemoteUrls;
    }

    public ProcessRemoteDBModel getProcessRemote() {
        return processRemote;
    }

    public void setProcessRemote(ProcessRemoteDBModel processRemote) {
        this.processRemote = processRemote;
    }

    public List<UrlDBModel> getProcessRemoteUrls() {
        return processRemoteUrls;
    }

    public void setProcessRemoteUrls(List<UrlDBModel> processRemoteUrls) {
        this.processRemoteUrls = processRemoteUrls;
    }
}

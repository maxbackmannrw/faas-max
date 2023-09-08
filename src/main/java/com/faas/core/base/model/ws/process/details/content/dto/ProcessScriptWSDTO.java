package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessScriptDAO;

public class ProcessScriptWSDTO {

    private ProcessScriptDAO callScript;

    public ProcessScriptWSDTO() {
    }

    public ProcessScriptWSDTO(ProcessScriptDAO callScript) {
        this.callScript = callScript;
    }

    public ProcessScriptDAO getCallScript() {
        return callScript;
    }

    public void setCallScript(ProcessScriptDAO callScript) {
        this.callScript = callScript;
    }
}

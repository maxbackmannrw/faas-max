package com.faas.core.base.model.ws.process.details.script.dto;

import com.faas.core.base.model.db.process.content.dao.ProcessScriptDAO;

public class ProcessScriptWSDTO {

    private ProcessScriptDAO processScript;

    public ProcessScriptWSDTO() {
    }

    public ProcessScriptWSDTO(ProcessScriptDAO processScript) {
        this.processScript = processScript;
    }

    public ProcessScriptDAO getProcessScript() {
        return processScript;
    }

    public void setProcessScript(ProcessScriptDAO processScript) {
        this.processScript = processScript;
    }
}

package com.faas.core.base.model.ws.process.details.content.dto;

import com.faas.core.base.model.db.process.content.dao.CallScriptDAO;

public class CallScriptWSDTO {

    private CallScriptDAO callScript;

    public CallScriptWSDTO() {
    }

    public CallScriptWSDTO(CallScriptDAO callScript) {
        this.callScript = callScript;
    }

    public CallScriptDAO getCallScript() {
        return callScript;
    }

    public void setCallScript(CallScriptDAO callScript) {
        this.callScript = callScript;
    }
}

package com.faas.core.base.model.ws.process.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.CallScriptWSDTO;

import java.util.List;

public class CallScriptWSModel {

    private GeneralWSModel general;
    private List<CallScriptWSDTO>callScripts;

    public CallScriptWSModel() {
    }

    public CallScriptWSModel(GeneralWSModel general, List<CallScriptWSDTO> callScripts) {
        this.general = general;
        this.callScripts = callScripts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<CallScriptWSDTO> getCallScripts() {
        return callScripts;
    }

    public void setCallScripts(List<CallScriptWSDTO> callScripts) {
        this.callScripts = callScripts;
    }
}

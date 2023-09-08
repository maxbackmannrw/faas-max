package com.faas.core.base.model.ws.process.details.content;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.details.content.dto.ProcessScriptWSDTO;

import java.util.List;

public class ProcessScriptWSModel {

    private GeneralWSModel general;
    private List<ProcessScriptWSDTO>processScripts;

    public ProcessScriptWSModel() {
    }

    public ProcessScriptWSModel(GeneralWSModel general, List<ProcessScriptWSDTO> processScripts) {
        this.general = general;
        this.processScripts = processScripts;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessScriptWSDTO> getProcessScripts() {
        return processScripts;
    }

    public void setProcessScripts(List<ProcessScriptWSDTO> processScripts) {
        this.processScripts = processScripts;
    }
}

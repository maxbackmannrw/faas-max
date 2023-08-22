package com.faas.core.base.model.ws.process.settings;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.process.settings.dto.ProcessTypeWSDTO;

import java.util.List;

public class ProcessTypeWSModel {

    private GeneralWSModel general;
    private List<ProcessTypeWSDTO> processTypes;


    public ProcessTypeWSModel() {
    }

    public ProcessTypeWSModel(GeneralWSModel general, List<ProcessTypeWSDTO> processTypes) {
        this.general = general;
        this.processTypes = processTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ProcessTypeWSDTO> getProcessTypes() {
        return processTypes;
    }

    public void setProcessTypes(List<ProcessTypeWSDTO> processTypes) {
        this.processTypes = processTypes;
    }
}

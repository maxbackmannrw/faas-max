package com.faas.core.base.model.ws.manager.manual;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.manager.manual.dto.ManualOperationWSDTO;

import java.util.List;

public class ManualOperationWSModel {

    private GeneralWSModel general;
    private List<ManualOperationWSDTO> manualOperations;

    public ManualOperationWSModel() {
    }

    public ManualOperationWSModel(GeneralWSModel general, List<ManualOperationWSDTO> manualOperations) {
        this.general = general;
        this.manualOperations = manualOperations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ManualOperationWSDTO> getManualOperations() {
        return manualOperations;
    }

    public void setManualOperations(List<ManualOperationWSDTO> manualOperations) {
        this.manualOperations = manualOperations;
    }
}

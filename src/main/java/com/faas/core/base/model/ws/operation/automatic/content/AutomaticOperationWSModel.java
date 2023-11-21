package com.faas.core.base.model.ws.operation.automatic.content;

import com.faas.core.base.model.ws.operation.automatic.content.dto.AutomaticOperationWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class AutomaticOperationWSModel {

    private GeneralWSModel general;
    private List<AutomaticOperationWSDTO>automaticOperations;

    public AutomaticOperationWSModel() {
    }

    public AutomaticOperationWSModel(GeneralWSModel general, List<AutomaticOperationWSDTO> automaticOperations) {
        this.general = general;
        this.automaticOperations = automaticOperations;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<AutomaticOperationWSDTO> getAutomaticOperations() {
        return automaticOperations;
    }

    public void setAutomaticOperations(List<AutomaticOperationWSDTO> automaticOperations) {
        this.automaticOperations = automaticOperations;
    }
}

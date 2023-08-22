package com.faas.core.base.model.ws.scenario.settings;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.settings.dto.VariableTypeWSDTO;

import java.util.List;

public class VariableTypeWSModel {

    private GeneralWSModel general;
    private List<VariableTypeWSDTO>variableTypes;


    public VariableTypeWSModel() {
    }

    public VariableTypeWSModel(GeneralWSModel general, List<VariableTypeWSDTO> variableTypes) {
        this.general = general;
        this.variableTypes = variableTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<VariableTypeWSDTO> getVariableTypes() {
        return variableTypes;
    }

    public void setVariableTypes(List<VariableTypeWSDTO> variableTypes) {
        this.variableTypes = variableTypes;
    }
}

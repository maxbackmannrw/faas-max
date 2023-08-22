package com.faas.core.base.model.ws.scenario.settings.dto;

import com.faas.core.base.model.db.scenario.settings.VariableTypeDBModel;

public class VariableTypeWSDTO {

    private VariableTypeDBModel variableType;

    public VariableTypeWSDTO() {
    }

    public VariableTypeWSDTO(VariableTypeDBModel variableType) {
        this.variableType = variableType;
    }

    public VariableTypeDBModel getVariableType() {
        return variableType;
    }

    public void setVariableType(VariableTypeDBModel variableType) {
        this.variableType = variableType;
    }
}

package com.faas.core.base.model.ws.scenario.details.element.details.dto;

import com.faas.core.base.model.db.scenario.content.dao.ElementVariableDAO;

public class ElementVariableWSDTO {

    private ElementVariableDAO elementVariable;

    public ElementVariableWSDTO() {
    }

    public ElementVariableWSDTO(ElementVariableDAO elementVariable) {
        this.elementVariable = elementVariable;
    }

    public ElementVariableDAO getElementVariable() {
        return elementVariable;
    }

    public void setElementVariable(ElementVariableDAO elementVariable) {
        this.elementVariable = elementVariable;
    }
}

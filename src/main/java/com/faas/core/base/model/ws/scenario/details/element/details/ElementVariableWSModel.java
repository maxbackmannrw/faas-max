package com.faas.core.base.model.ws.scenario.details.element.details;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.scenario.details.content.dto.ScenarioVariableWSDTO;
import com.faas.core.base.model.ws.scenario.details.element.details.dto.ElementVariableWSDTO;

import java.util.List;

public class ElementVariableWSModel {

    private GeneralWSModel general;
    private List<ElementVariableWSDTO> elementVariables;

    public ElementVariableWSModel() {
    }

    public ElementVariableWSModel(GeneralWSModel general, List<ElementVariableWSDTO> elementVariables) {
        this.general = general;
        this.elementVariables = elementVariables;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ElementVariableWSDTO> getElementVariables() {
        return elementVariables;
    }

    public void setElementVariables(List<ElementVariableWSDTO> elementVariables) {
        this.elementVariables = elementVariables;
    }
}

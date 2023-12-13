package com.faas.core.base.model.ws.action;

import com.faas.core.base.model.ws.action.dto.ActionWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ActionWSModel {

    private GeneralWSModel general;
    private List<ActionWSDTO>actions;

    public ActionWSModel() {
    }

    public ActionWSModel(GeneralWSModel general, List<ActionWSDTO> actions) {
        this.general = general;
        this.actions = actions;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ActionWSDTO> getActions() {
        return actions;
    }

    public void setActions(List<ActionWSDTO> actions) {
        this.actions = actions;
    }
}

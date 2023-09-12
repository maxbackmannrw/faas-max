package com.faas.core.base.model.ws.scenario.temp.action;

import com.faas.core.base.model.ws.scenario.temp.action.dto.ActionTempWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ActionTempWSModel {

    private GeneralWSModel general;
    private List<ActionTempWSDTO>actionTemps;

    public ActionTempWSModel() {
    }

    public ActionTempWSModel(GeneralWSModel general, List<ActionTempWSDTO> actionTemps) {
        this.general = general;
        this.actionTemps = actionTemps;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ActionTempWSDTO> getActionTemps() {
        return actionTemps;
    }

    public void setActionTemps(List<ActionTempWSDTO> actionTemps) {
        this.actionTemps = actionTemps;
    }
}

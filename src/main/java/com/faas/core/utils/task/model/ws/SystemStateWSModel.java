package com.faas.core.utils.task.model.ws;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.utils.task.model.ws.dto.SystemStateWSDTO;

import java.util.List;

public class SystemStateWSModel {

    private GeneralWSModel general;
    private List<SystemStateWSDTO>systemStates;

    public SystemStateWSModel() {
    }

    public SystemStateWSModel(GeneralWSModel general, List<SystemStateWSDTO> systemStates) {
        this.general = general;
        this.systemStates = systemStates;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SystemStateWSDTO> getSystemStates() {
        return systemStates;
    }

    public void setSystemStates(List<SystemStateWSDTO> systemStates) {
        this.systemStates = systemStates;
    }
}

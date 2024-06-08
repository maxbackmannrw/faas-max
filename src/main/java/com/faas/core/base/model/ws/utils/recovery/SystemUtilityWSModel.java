package com.faas.core.base.model.ws.utils.recovery;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.recovery.dto.SystemUtilityWSDTO;

import java.util.List;

public class SystemUtilityWSModel {

    private GeneralWSModel general;
    private List<SystemUtilityWSDTO>systemUtilities;

    public SystemUtilityWSModel() {
    }

    public SystemUtilityWSModel(GeneralWSModel general, List<SystemUtilityWSDTO> systemUtilities) {
        this.general = general;
        this.systemUtilities = systemUtilities;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SystemUtilityWSDTO> getSystemUtilities() {
        return systemUtilities;
    }

    public void setSystemUtilities(List<SystemUtilityWSDTO> systemUtilities) {
        this.systemUtilities = systemUtilities;
    }
}

package com.faas.core.base.model.ws.utils.system;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.system.dto.SystemInfoWSDTO;

import java.util.List;

public class SystemInfoWSModel {

    private GeneralWSModel general;
    private List<SystemInfoWSDTO>systemInfos;

    public SystemInfoWSModel() {
    }

    public SystemInfoWSModel(GeneralWSModel general, List<SystemInfoWSDTO> systemInfos) {
        this.general = general;
        this.systemInfos = systemInfos;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SystemInfoWSDTO> getSystemInfos() {
        return systemInfos;
    }

    public void setSystemInfos(List<SystemInfoWSDTO> systemInfos) {
        this.systemInfos = systemInfos;
    }
}

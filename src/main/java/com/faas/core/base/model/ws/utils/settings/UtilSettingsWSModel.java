package com.faas.core.base.model.ws.utils.settings;

import com.faas.core.base.model.ws.general.GeneralWSModel;
import com.faas.core.base.model.ws.utils.settings.dto.UtilSettingsWSDTO;

import java.util.List;

public class UtilSettingsWSModel {

    private GeneralWSModel general;
    private List<UtilSettingsWSDTO>utilSettings;

    public UtilSettingsWSModel() {
    }

    public UtilSettingsWSModel(GeneralWSModel general, List<UtilSettingsWSDTO> utilSettings) {
        this.general = general;
        this.utilSettings = utilSettings;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<UtilSettingsWSDTO> getUtilSettings() {
        return utilSettings;
    }

    public void setUtilSettings(List<UtilSettingsWSDTO> utilSettings) {
        this.utilSettings = utilSettings;
    }
}

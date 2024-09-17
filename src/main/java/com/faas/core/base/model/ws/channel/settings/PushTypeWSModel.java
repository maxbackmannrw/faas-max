package com.faas.core.base.model.ws.channel.settings;

import com.faas.core.base.model.ws.channel.settings.dto.PushTypeWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class PushTypeWSModel {

    private GeneralWSModel general;
    private List<PushTypeWSDTO> pushTypes;

    public PushTypeWSModel() {
    }

    public PushTypeWSModel(GeneralWSModel general, List<PushTypeWSDTO> pushTypes) {
        this.general = general;
        this.pushTypes = pushTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<PushTypeWSDTO> getPushTypes() {
        return pushTypes;
    }

    public void setPushTypes(List<PushTypeWSDTO> pushTypes) {
        this.pushTypes = pushTypes;
    }
}

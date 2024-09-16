package com.faas.core.data.ws.base.utilz.content;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.utilz.content.dto.SystemInitWSDTO;

public class SystemInitWSModel {

    private GeneralWSModel general;
    private SystemInitWSDTO systemInit;

    public SystemInitWSModel() {
    }

    public SystemInitWSModel(GeneralWSModel general, SystemInitWSDTO systemInit) {
        this.general = general;
        this.systemInit = systemInit;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public SystemInitWSDTO getSystemInit() {
        return systemInit;
    }

    public void setSystemInit(SystemInitWSDTO systemInit) {
        this.systemInit = systemInit;
    }
}

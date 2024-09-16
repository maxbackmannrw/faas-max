package com.faas.core.data.ws.base.utilz.content;

import com.faas.core.data.ws.base.general.GeneralWSModel;
import com.faas.core.data.ws.base.utilz.content.dto.SystemContentWSDTO;

import java.util.List;

public class SystemContentWSModel {

    private GeneralWSModel general;
    private List<SystemContentWSDTO> systemContents;

    public SystemContentWSModel() {
    }

    public SystemContentWSModel(GeneralWSModel general, List<SystemContentWSDTO> systemContents) {
        this.general = general;
        this.systemContents = systemContents;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<SystemContentWSDTO> getSystemContents() {
        return systemContents;
    }

    public void setSystemContents(List<SystemContentWSDTO> systemContents) {
        this.systemContents = systemContents;
    }
}

package com.faas.core.base.model.ws.channel.settings;

import com.faas.core.base.model.ws.channel.settings.dto.WappServerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class WappServerWSModel {

    private GeneralWSModel general;
    private List<WappServerWSDTO> wappServers;

    public WappServerWSModel() {
    }

    public WappServerWSModel(GeneralWSModel general, List<WappServerWSDTO> wappServers) {
        this.general = general;
        this.wappServers = wappServers;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<WappServerWSDTO> getWappServers() {
        return wappServers;
    }

    public void setWappServers(List<WappServerWSDTO> wappServers) {
        this.wappServers = wappServers;
    }
}

package com.faas.core.data.ws.base.client.settings;

import com.faas.core.data.ws.base.client.settings.dto.ClientTypeWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ClientTypeWSModel {

    private GeneralWSModel general;
    private List<ClientTypeWSDTO> clientTypes;


    public ClientTypeWSModel() {
    }

    public ClientTypeWSModel(GeneralWSModel general, List<ClientTypeWSDTO> clientTypes) {
        this.general = general;
        this.clientTypes = clientTypes;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientTypeWSDTO> getClientTypes() {
        return clientTypes;
    }

    public void setClientTypes(List<ClientTypeWSDTO> clientTypes) {
        this.clientTypes = clientTypes;
    }
}

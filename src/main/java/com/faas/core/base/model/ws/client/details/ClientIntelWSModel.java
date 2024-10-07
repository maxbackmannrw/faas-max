package com.faas.core.base.model.ws.client.details;

import com.faas.core.base.model.ws.client.details.dto.ClientIntelWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ClientIntelWSModel {

    private GeneralWSModel general;
    private List<ClientIntelWSDTO>clientIntels;

    public ClientIntelWSModel() {
    }

    public ClientIntelWSModel(GeneralWSModel general, List<ClientIntelWSDTO> clientIntels) {
        this.general = general;
        this.clientIntels = clientIntels;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientIntelWSDTO> getClientIntels() {
        return clientIntels;
    }

    public void setClientIntels(List<ClientIntelWSDTO> clientIntels) {
        this.clientIntels = clientIntels;
    }
}

package com.faas.core.base.model.ws.client.details;

import com.faas.core.base.model.ws.client.details.dto.ClientDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ClientDetailsWSModel {

    private GeneralWSModel general;
    private List<ClientDetailsWSDTO>clientDetails;

    public ClientDetailsWSModel() {
    }

    public ClientDetailsWSModel(GeneralWSModel general, List<ClientDetailsWSDTO> clientDetails) {
        this.general = general;
        this.clientDetails = clientDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientDetailsWSDTO> getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(List<ClientDetailsWSDTO> clientDetails) {
        this.clientDetails = clientDetails;
    }
}

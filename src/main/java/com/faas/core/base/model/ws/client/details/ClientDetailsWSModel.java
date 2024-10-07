package com.faas.core.base.model.ws.client.details;

import com.faas.core.base.model.ws.client.details.dto.ClientDetailsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ClientDetailsWSModel {

    private GeneralWSModel general;
    private ClientDetailsWSDTO clientDetails;

    public ClientDetailsWSModel() {
    }

    public ClientDetailsWSModel(GeneralWSModel general, ClientDetailsWSDTO clientDetails) {
        this.general = general;
        this.clientDetails = clientDetails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientDetailsWSDTO getClientDetails() {
        return clientDetails;
    }

    public void setClientDetails(ClientDetailsWSDTO clientDetails) {
        this.clientDetails = clientDetails;
    }
}

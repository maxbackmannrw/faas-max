package com.faas.core.data.ws.base.client.details.content;

import com.faas.core.data.ws.base.client.details.content.dto.ClientDetailsWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;


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

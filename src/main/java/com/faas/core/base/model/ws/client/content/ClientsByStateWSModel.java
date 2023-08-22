package com.faas.core.base.model.ws.client.content;

import com.faas.core.base.model.ws.client.content.dto.ClientsByStateWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ClientsByStateWSModel {

    private GeneralWSModel general;
    private ClientsByStateWSDTO clients;

    public ClientsByStateWSModel() {
    }

    public ClientsByStateWSModel(GeneralWSModel general, ClientsByStateWSDTO clients) {
        this.general = general;
        this.clients = clients;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientsByStateWSDTO getClients() {
        return clients;
    }

    public void setClients(ClientsByStateWSDTO clients) {
        this.clients = clients;
    }
}

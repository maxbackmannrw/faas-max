package com.faas.core.base.model.ws.client.content;

import com.faas.core.base.model.ws.client.content.dto.ClientListWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ClientListWSModel {

    private GeneralWSModel general;
    private ClientListWSDTO clientList;

    public ClientListWSModel() {
    }

    public ClientListWSModel(GeneralWSModel general, ClientListWSDTO clientList) {
        this.general = general;
        this.clientList = clientList;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ClientListWSDTO getClientList() {
        return clientList;
    }

    public void setClientList(ClientListWSDTO clientList) {
        this.clientList = clientList;
    }
}

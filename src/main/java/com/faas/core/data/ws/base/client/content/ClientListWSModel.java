package com.faas.core.data.ws.base.client.content;

import com.faas.core.data.ws.base.client.content.dto.ClientListWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;


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

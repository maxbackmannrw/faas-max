package com.faas.core.data.ws.base.client.content;

import com.faas.core.data.ws.base.client.content.dto.ClientWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ClientWSModel {

    private GeneralWSModel general;
    private List<ClientWSDTO> clients;

    public ClientWSModel() {
    }

    public ClientWSModel(GeneralWSModel general, List<ClientWSDTO> clients) {
        this.general = general;
        this.clients = clients;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientWSDTO> getClients() {
        return clients;
    }

    public void setClients(List<ClientWSDTO> clients) {
        this.clients = clients;
    }
}

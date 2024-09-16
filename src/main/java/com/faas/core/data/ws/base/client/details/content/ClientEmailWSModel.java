package com.faas.core.data.ws.base.client.details.content;

import com.faas.core.data.ws.base.client.details.content.dto.ClientEmailWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;

public class ClientEmailWSModel {

    private GeneralWSModel general;
    private List<ClientEmailWSDTO> clientEmails;

    public ClientEmailWSModel() {
    }

    public ClientEmailWSModel(GeneralWSModel general, List<ClientEmailWSDTO> clientEmails) {
        this.general = general;
        this.clientEmails = clientEmails;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientEmailWSDTO> getClientEmails() {
        return clientEmails;
    }

    public void setClientEmails(List<ClientEmailWSDTO> clientEmails) {
        this.clientEmails = clientEmails;
    }
}

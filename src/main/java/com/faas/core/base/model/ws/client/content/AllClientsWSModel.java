package com.faas.core.base.model.ws.client.content;

import com.faas.core.base.model.ws.client.content.dto.AllClientsWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class AllClientsWSModel {

    private GeneralWSModel general;
    private AllClientsWSDTO allClients;

    public AllClientsWSModel() {
    }

    public AllClientsWSModel(GeneralWSModel general, AllClientsWSDTO allClients) {
        this.general = general;
        this.allClients = allClients;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public AllClientsWSDTO getAllClients() {
        return allClients;
    }

    public void setAllClients(AllClientsWSDTO allClients) {
        this.allClients = allClients;
    }
}

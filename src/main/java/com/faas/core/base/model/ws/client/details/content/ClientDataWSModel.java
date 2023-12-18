package com.faas.core.base.model.ws.client.details.content;

import com.faas.core.base.model.ws.client.details.content.dto.ClientDataWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;

import java.util.List;

public class ClientDataWSModel {

    private GeneralWSModel general;
    private List<ClientDataWSDTO>clientDatas;

    public ClientDataWSModel() {
    }

    public ClientDataWSModel(GeneralWSModel general, List<ClientDataWSDTO> clientDatas) {
        this.general = general;
        this.clientDatas = clientDatas;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientDataWSDTO> getClientDatas() {
        return clientDatas;
    }

    public void setClientDatas(List<ClientDataWSDTO> clientDatas) {
        this.clientDatas = clientDatas;
    }
}

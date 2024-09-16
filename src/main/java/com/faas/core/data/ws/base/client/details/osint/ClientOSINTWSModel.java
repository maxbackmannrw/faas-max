package com.faas.core.data.ws.base.client.details.osint;

import com.faas.core.data.ws.base.client.details.osint.dto.ClientOSINTWSDTO;
import com.faas.core.data.ws.base.general.GeneralWSModel;

import java.util.List;


public class ClientOSINTWSModel {

    private GeneralWSModel general;
    private List<ClientOSINTWSDTO> clientOSINTs;

    public ClientOSINTWSModel() {
    }

    public ClientOSINTWSModel(GeneralWSModel general, List<ClientOSINTWSDTO> clientOSINTs) {
        this.general = general;
        this.clientOSINTs = clientOSINTs;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public List<ClientOSINTWSDTO> getClientOSINTs() {
        return clientOSINTs;
    }

    public void setClientOSINTs(List<ClientOSINTWSDTO> clientOSINTs) {
        this.clientOSINTs = clientOSINTs;
    }
}

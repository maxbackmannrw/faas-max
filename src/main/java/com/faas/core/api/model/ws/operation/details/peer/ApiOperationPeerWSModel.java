package com.faas.core.api.model.ws.operation.details.peer;

import com.faas.core.api.model.ws.operation.details.peer.dto.ApiOperationPeerWSDTO;
import com.faas.core.base.model.ws.general.GeneralWSModel;


public class ApiOperationPeerWSModel {

    private GeneralWSModel general;
    private ApiOperationPeerWSDTO operationPeer;

    public ApiOperationPeerWSModel() {
    }

    public ApiOperationPeerWSModel(GeneralWSModel general, ApiOperationPeerWSDTO operationPeer) {
        this.general = general;
        this.operationPeer = operationPeer;
    }

    public GeneralWSModel getGeneral() {
        return general;
    }

    public void setGeneral(GeneralWSModel general) {
        this.general = general;
    }

    public ApiOperationPeerWSDTO getOperationPeer() {
        return operationPeer;
    }

    public void setOperationPeer(ApiOperationPeerWSDTO operationPeer) {
        this.operationPeer = operationPeer;
    }
}

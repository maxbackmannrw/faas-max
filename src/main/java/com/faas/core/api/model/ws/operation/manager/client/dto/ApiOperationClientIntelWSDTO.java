package com.faas.core.api.model.ws.operation.manager.client.dto;


import com.faas.core.data.db.client.intel.ClientIntelDBModel;

public class ApiOperationClientIntelWSDTO {

    ClientIntelDBModel operationClientIntel;

    public ApiOperationClientIntelWSDTO() {
    }

    public ApiOperationClientIntelWSDTO(ClientIntelDBModel operationClientIntel) {
        this.operationClientIntel = operationClientIntel;
    }

    public ClientIntelDBModel getOperationClientIntel() {
        return operationClientIntel;
    }

    public void setOperationClientIntel(ClientIntelDBModel operationClientIntel) {
        this.operationClientIntel = operationClientIntel;
    }
}

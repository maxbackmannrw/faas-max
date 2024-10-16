package com.faas.core.api.model.ws.operation.manager.intel.dto;


import com.faas.core.data.db.client.intel.ClientIntelDBModel;

public class ApiOperationIntelWSDTO {

    ClientIntelDBModel operationIntel;

    public ApiOperationIntelWSDTO() {
    }

    public ApiOperationIntelWSDTO(ClientIntelDBModel operationIntel) {
        this.operationIntel = operationIntel;
    }

    public ClientIntelDBModel getOperationIntel() {
        return operationIntel;
    }

    public void setOperationIntel(ClientIntelDBModel operationIntel) {
        this.operationIntel = operationIntel;
    }
}

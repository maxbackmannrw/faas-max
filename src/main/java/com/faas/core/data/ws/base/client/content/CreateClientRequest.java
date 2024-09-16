package com.faas.core.data.ws.base.client.content;

import com.faas.core.data.ws.base.client.content.dto.CreateClientRequestDTO;

import java.util.List;

public class CreateClientRequest {

    private List<CreateClientRequestDTO> createClients;

    public CreateClientRequest() {
    }

    public CreateClientRequest(List<CreateClientRequestDTO> createClients) {
        this.createClients = createClients;
    }

    public List<CreateClientRequestDTO> getCreateClients() {
        return createClients;
    }

    public void setCreateClients(List<CreateClientRequestDTO> createClients) {
        this.createClients = createClients;
    }
}

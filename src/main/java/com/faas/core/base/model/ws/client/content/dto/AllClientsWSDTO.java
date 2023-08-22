package com.faas.core.base.model.ws.client.content.dto;

public class AllClientsWSDTO {

    private ClientsByStateWSDTO allClients;
    private ClientsByStateWSDTO readyClients;
    private ClientsByStateWSDTO busyClients;

    public AllClientsWSDTO() {
    }

    public AllClientsWSDTO(ClientsByStateWSDTO allClients, ClientsByStateWSDTO readyClients, ClientsByStateWSDTO busyClients) {
        this.allClients = allClients;
        this.readyClients = readyClients;
        this.busyClients = busyClients;
    }

    public ClientsByStateWSDTO getAllClients() {
        return allClients;
    }

    public void setAllClients(ClientsByStateWSDTO allClients) {
        this.allClients = allClients;
    }

    public ClientsByStateWSDTO getReadyClients() {
        return readyClients;
    }

    public void setReadyClients(ClientsByStateWSDTO readyClients) {
        this.readyClients = readyClients;
    }

    public ClientsByStateWSDTO getBusyClients() {
        return busyClients;
    }

    public void setBusyClients(ClientsByStateWSDTO busyClients) {
        this.busyClients = busyClients;
    }
}

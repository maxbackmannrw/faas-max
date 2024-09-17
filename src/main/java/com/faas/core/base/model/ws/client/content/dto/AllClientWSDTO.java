package com.faas.core.base.model.ws.client.content.dto;

public class AllClientWSDTO {

    private ClientListWSDTO clients;
    private ClientListWSDTO readyClients;
    private ClientListWSDTO busyClients;

    public AllClientWSDTO() {
    }

    public AllClientWSDTO(ClientListWSDTO clients, ClientListWSDTO readyClients, ClientListWSDTO busyClients) {
        this.clients = clients;
        this.readyClients = readyClients;
        this.busyClients = busyClients;
    }

    public ClientListWSDTO getClients() {
        return clients;
    }

    public void setClients(ClientListWSDTO clients) {
        this.clients = clients;
    }

    public ClientListWSDTO getReadyClients() {
        return readyClients;
    }

    public void setReadyClients(ClientListWSDTO readyClients) {
        this.readyClients = readyClients;
    }

    public ClientListWSDTO getBusyClients() {
        return busyClients;
    }

    public void setBusyClients(ClientListWSDTO busyClients) {
        this.busyClients = busyClients;
    }
}

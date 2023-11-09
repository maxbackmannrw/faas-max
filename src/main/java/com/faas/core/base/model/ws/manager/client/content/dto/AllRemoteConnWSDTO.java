package com.faas.core.base.model.ws.manager.client.content.dto;

public class AllRemoteConnWSDTO {

    private RemoteConnListWSDTO readyConnList;
    private RemoteConnListWSDTO activeConnList;
    private RemoteConnListWSDTO inActiveConnList;

    public AllRemoteConnWSDTO() {
    }

    public AllRemoteConnWSDTO(RemoteConnListWSDTO readyConnList, RemoteConnListWSDTO activeConnList, RemoteConnListWSDTO inActiveConnList) {
        this.readyConnList = readyConnList;
        this.activeConnList = activeConnList;
        this.inActiveConnList = inActiveConnList;
    }

    public RemoteConnListWSDTO getReadyConnList() {
        return readyConnList;
    }

    public void setReadyConnList(RemoteConnListWSDTO readyConnList) {
        this.readyConnList = readyConnList;
    }

    public RemoteConnListWSDTO getActiveConnList() {
        return activeConnList;
    }

    public void setActiveConnList(RemoteConnListWSDTO activeConnList) {
        this.activeConnList = activeConnList;
    }

    public RemoteConnListWSDTO getInActiveConnList() {
        return inActiveConnList;
    }

    public void setInActiveConnList(RemoteConnListWSDTO inActiveConnList) {
        this.inActiveConnList = inActiveConnList;
    }
}


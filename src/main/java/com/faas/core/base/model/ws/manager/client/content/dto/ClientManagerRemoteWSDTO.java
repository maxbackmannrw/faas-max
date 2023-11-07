package com.faas.core.base.model.ws.manager.client.content.dto;

public class ClientManagerRemoteWSDTO {

    private ClientRemoteListWSDTO activeRemoteList;
    private ClientRemoteListWSDTO inactiveRemoteList;

    public ClientManagerRemoteWSDTO() {
    }

    public ClientManagerRemoteWSDTO(ClientRemoteListWSDTO activeRemoteList, ClientRemoteListWSDTO inactiveRemoteList) {
        this.activeRemoteList = activeRemoteList;
        this.inactiveRemoteList = inactiveRemoteList;
    }

    public ClientRemoteListWSDTO getActiveRemoteList() {
        return activeRemoteList;
    }

    public void setActiveRemoteList(ClientRemoteListWSDTO activeRemoteList) {
        this.activeRemoteList = activeRemoteList;
    }

    public ClientRemoteListWSDTO getInactiveRemoteList() {
        return inactiveRemoteList;
    }

    public void setInactiveRemoteList(ClientRemoteListWSDTO inactiveRemoteList) {
        this.inactiveRemoteList = inactiveRemoteList;
    }
}


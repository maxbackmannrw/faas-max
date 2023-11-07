package com.faas.core.base.model.ws.manager.client.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ClientRemoteListWSDTO {

    private List<ClientRemoteWSDTO> clientRemotes;
    public PaginationWSDTO pagination;

    public ClientRemoteListWSDTO() {
    }

    public ClientRemoteListWSDTO(List<ClientRemoteWSDTO> clientRemotes, PaginationWSDTO pagination) {
        this.clientRemotes = clientRemotes;
        this.pagination = pagination;
    }

    public List<ClientRemoteWSDTO> getClientRemotes() {
        return clientRemotes;
    }

    public void setClientRemotes(List<ClientRemoteWSDTO> clientRemotes) {
        this.clientRemotes = clientRemotes;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}


package com.faas.core.base.model.ws.remote.client.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class ClientRemoteListWSDTO {

    private List<ClientRemoteWSDTO> remotes;
    public PaginationWSDTO pagination;

    public ClientRemoteListWSDTO() {
    }

    public ClientRemoteListWSDTO(List<ClientRemoteWSDTO> remotes, PaginationWSDTO pagination) {
        this.remotes = remotes;
        this.pagination = pagination;
    }

    public List<ClientRemoteWSDTO> getRemotes() {
        return remotes;
    }

    public void setRemotes(List<ClientRemoteWSDTO> remotes) {
        this.remotes = remotes;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}


package com.faas.core.base.model.ws.remote.app.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class RemoteClientListWSDTO {

    private List<RemoteClientWSDTO> clientRemotes;
    public PaginationWSDTO pagination;

    public RemoteClientListWSDTO() {
    }

    public RemoteClientListWSDTO(List<RemoteClientWSDTO> clientRemotes, PaginationWSDTO pagination) {
        this.clientRemotes = clientRemotes;
        this.pagination = pagination;
    }

    public List<RemoteClientWSDTO> getClientRemotes() {
        return clientRemotes;
    }

    public void setClientRemotes(List<RemoteClientWSDTO> clientRemotes) {
        this.clientRemotes = clientRemotes;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}


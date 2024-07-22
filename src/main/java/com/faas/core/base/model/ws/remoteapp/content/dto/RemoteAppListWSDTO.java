package com.faas.core.base.model.ws.remoteapp.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class RemoteAppListWSDTO {

    private List<RemoteAppWSDTO> clientRemotes;
    public PaginationWSDTO pagination;

    public RemoteAppListWSDTO() {
    }

    public RemoteAppListWSDTO(List<RemoteAppWSDTO> clientRemotes, PaginationWSDTO pagination) {
        this.clientRemotes = clientRemotes;
        this.pagination = pagination;
    }

    public List<RemoteAppWSDTO> getClientRemotes() {
        return clientRemotes;
    }

    public void setClientRemotes(List<RemoteAppWSDTO> clientRemotes) {
        this.clientRemotes = clientRemotes;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}


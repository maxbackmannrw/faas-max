package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class RemoteConnListWSDTO {

    private List<RemoteConnWSDTO> remoteConns;
    public PaginationWSDTO pagination;

    public RemoteConnListWSDTO() {
    }

    public RemoteConnListWSDTO(List<RemoteConnWSDTO> remoteConns, PaginationWSDTO pagination) {
        this.remoteConns = remoteConns;
        this.pagination = pagination;
    }

    public List<RemoteConnWSDTO> getRemoteConns() {
        return remoteConns;
    }

    public void setRemoteConns(List<RemoteConnWSDTO> remoteConns) {
        this.remoteConns = remoteConns;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}


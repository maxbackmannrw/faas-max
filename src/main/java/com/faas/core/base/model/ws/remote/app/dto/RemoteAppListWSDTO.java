package com.faas.core.base.model.ws.remote.app.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class RemoteAppListWSDTO {

    private List<RemoteAppWSDTO> remotes;
    public PaginationWSDTO pagination;

    public RemoteAppListWSDTO() {
    }

    public RemoteAppListWSDTO(List<RemoteAppWSDTO> remotes, PaginationWSDTO pagination) {
        this.remotes = remotes;
        this.pagination = pagination;
    }

    public List<RemoteAppWSDTO> getRemotes() {
        return remotes;
    }

    public void setRemotes(List<RemoteAppWSDTO> remotes) {
        this.remotes = remotes;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}


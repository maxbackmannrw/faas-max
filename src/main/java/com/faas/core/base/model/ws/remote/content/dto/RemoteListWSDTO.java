package com.faas.core.base.model.ws.remote.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class RemoteListWSDTO {

    private List<RemoteWSDTO> remotes;
    public PaginationWSDTO pagination;

    public RemoteListWSDTO() {
    }

    public RemoteListWSDTO(List<RemoteWSDTO> remotes, PaginationWSDTO pagination) {
        this.remotes = remotes;
        this.pagination = pagination;
    }

    public List<RemoteWSDTO> getRemotes() {
        return remotes;
    }

    public void setRemotes(List<RemoteWSDTO> remotes) {
        this.remotes = remotes;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}


package com.faas.core.base.model.ws.remoteapp.content.dto;

import com.faas.core.base.model.ws.general.PaginationWSDTO;

import java.util.List;

public class RemoteAppListWSDTO {

    private List<RemoteAppWSDTO> remoteApps;
    public PaginationWSDTO pagination;

    public RemoteAppListWSDTO() {
    }

    public RemoteAppListWSDTO(List<RemoteAppWSDTO> remoteApps, PaginationWSDTO pagination) {
        this.remoteApps = remoteApps;
        this.pagination = pagination;
    }

    public List<RemoteAppWSDTO> getRemoteApps() {
        return remoteApps;
    }

    public void setRemoteApps(List<RemoteAppWSDTO> remoteApps) {
        this.remoteApps = remoteApps;
    }

    public PaginationWSDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationWSDTO pagination) {
        this.pagination = pagination;
    }
}


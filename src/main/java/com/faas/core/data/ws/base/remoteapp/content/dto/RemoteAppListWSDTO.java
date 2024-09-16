package com.faas.core.data.ws.base.remoteapp.content.dto;

import com.faas.core.data.ws.base.general.PaginationWSDTO;

import java.util.List;

public class RemoteAppListWSDTO {

    public PaginationWSDTO pagination;
    private List<RemoteAppWSDTO> remoteApps;

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

